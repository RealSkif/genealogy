package genealogy.data.settlement

import genealogy.data.document.DocumentEntity
import genealogy.data.document.DocumentEntityFactory.toEntity
import genealogy.data.document.DocumentJpaRepository
import genealogy.data.settlement.SettlementEntityFactory.toEntity
import genealogy.domain.settlement.Settlement
import genealogy.domain.settlement.SettlementRepository
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.stereotype.Repository
import java.util.*

/** Репозиторий для работы с поселениями */
@Repository
class SettlementRepositoryImpl(
    private val settlementJpaRepository: SettlementJpaRepository,
    private val documentJpaRepository: DocumentJpaRepository
) : SettlementRepository {
    override fun save(settlement: Settlement) {
        val settlementEntity = settlement.toEntity()
        val documents: Collection<DocumentEntity> =
            documentJpaRepository.findByTitleIn(settlement.documents.map { it.title }) ?: listOf()
        documents.union(settlement.documents.toEntity())
        documents.distinctBy { it.title }

        settlementEntity.documents = documents.toMutableList()
        documents.forEach { it.settlements?.add(settlementEntity) }
        settlementJpaRepository.save(settlementEntity)
        documentJpaRepository.saveAll(documents)
    }

    override fun saveAll(settlements: Collection<Settlement>) {
        //TODO: Переписать на сохранение в бд пачкой
        settlements.forEach { save(it) }
    }

    override fun delete(settlementId: UUID) {
        settlementJpaRepository.deleteById(settlementId)
    }

    override fun deleteBatch(settlementIds: Collection<UUID>) {
        settlementJpaRepository.deleteAllById(settlementIds)
    }

    override fun findBySettlementName(settlementName: String): Settlement? =
        settlementJpaRepository.findBySettlementName(settlementName)


    override fun findBySettlementName(settlementNames: Collection<String>): Collection<Settlement>? =
        settlementJpaRepository.findBySettlementNameIn(settlementNames)


    @EntityGraph(attributePaths = ["documents", "persons"])
    override fun findAll(): Collection<Settlement> =
        settlementJpaRepository.findAll()
}

