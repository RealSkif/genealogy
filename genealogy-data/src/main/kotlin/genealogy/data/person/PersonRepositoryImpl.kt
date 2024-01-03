package genealogy.data.person

import genealogy.data.document.DocumentEntity
import genealogy.data.document.DocumentEntityFactory.toEntity
import genealogy.data.document.DocumentJpaRepository
import genealogy.data.household.HouseHoldEntity
import genealogy.data.household.HouseHoldEntityFactory.toEntity
import genealogy.data.household.HouseHoldJpaRepository
import genealogy.data.person.PersonEntityFactory.toEntity
import genealogy.data.settlement.SettlementEntity
import genealogy.data.settlement.SettlementEntityFactory.toEntity
import genealogy.data.settlement.SettlementJpaRepository
import genealogy.domain.person.Person
import genealogy.domain.person.PersonRepository
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.stereotype.Repository
import java.util.*

/**
 * Репозиторий для работы с людьми
 */
@Repository
class PersonRepositoryImpl(
    private val settlementJpaRepository: SettlementJpaRepository,
    private val documentJpaRepository: DocumentJpaRepository,
    private val houseHoldJpaRepository: HouseHoldJpaRepository,
    private val personJpaRepository: PersonJpaRepository
) : PersonRepository {
    override fun save(person: Person) {
        val personEntity = person.toEntity()

        var documents: Collection<DocumentEntity> =
            documentJpaRepository.findByTitleIn(person.documents.map { it.title }) ?: listOf()
        documents = documents.union(person.documents.toEntity())
        documents = documents.distinctBy { it.title }

        var settlements: Collection<SettlementEntity> =
            settlementJpaRepository.findBySettlementNameIn(person.settlements.map { it.settlementName }) ?: listOf()
        settlements = settlements.union(person.settlements.toEntity())
        settlements = settlements.distinctBy { it.settlementName }

        var houseHolds: Collection<HouseHoldEntity> =
            houseHoldJpaRepository.findByHouseHoldNumberIn(person.houseHolds.map { it.houseHoldNumber }) ?: listOf()
        houseHolds = houseHolds.union(person.houseHolds.toEntity())
        houseHolds = houseHolds.distinctBy { it.houseHoldNumber }

        documents.forEach { it.persons?.add(personEntity) }
        settlements.forEach { it.persons?.add(personEntity) }
        houseHolds.forEach { it.persons.add(personEntity) }

        personJpaRepository.saveAndFlush(personEntity)
        personEntity.documents = documents.toMutableList()
        personEntity.settlements = settlements.toMutableList()
        personEntity.houseHolds = houseHolds.toMutableList()

        personJpaRepository.saveAndFlush(personEntity)
        documentJpaRepository.saveAllAndFlush(documents)
        settlementJpaRepository.saveAllAndFlush(settlements)
        houseHoldJpaRepository.saveAllAndFlush(houseHolds)

    }

    override fun saveAll(persons: Collection<Person>) {
        //TODO: Переписать на сохранение в бд пачкой
        persons.forEach { save(it) }
    }

    override fun delete(personId: UUID) {
        personJpaRepository.deleteById(personId)
    }

    override fun deleteBatch(personIds: Collection<UUID>) {
        personJpaRepository.deleteAllById(personIds)
    }

    override fun findByFullName(person: Person): Person? =
        personJpaRepository.findByFirstNameAndSecondNameAndMiddleName(
            firstName = person.firstName,
            secondName = person.secondName,
            middleName = person.middleName
        )


    override fun findByFullName(persons: Collection<Person>): Collection<Person>? {
        TODO("Not yet implemented")
    }

    @EntityGraph(attributePaths = ["documents", "settlements", "houseHolds"])
    override fun findAll(): Collection<Person> =
        personJpaRepository.findAll()
}