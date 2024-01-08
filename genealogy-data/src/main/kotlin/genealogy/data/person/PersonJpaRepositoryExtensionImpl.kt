package genealogy.data.person

import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.dsl.PathBuilder
import com.querydsl.jpa.impl.JPAQuery
import genealogy.data.document.QDocumentEntity.documentEntity
import genealogy.data.household.QHouseHoldEntity.houseHoldEntity
import genealogy.data.person.QPersonEntity.personEntity
import genealogy.data.settlement.QSettlementEntity.settlementEntity
import genealogy.domain.person.Person
import genealogy.domain.person.PersonFilter
import jakarta.persistence.EntityManager
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.support.Querydsl
import org.springframework.data.support.PageableExecutionUtils
import org.springframework.stereotype.Repository

@Repository
class PersonJpaRepositoryExtensionImpl(
    private val entityManager: EntityManager,
    private val personFilterBuilder: PersonFilterBuilder,

    ) : PersonJpaRepositoryExtension {

    private val queryDsl: Querydsl = Querydsl(entityManager, PathBuilder(PersonEntity::class.java, "PersonEntity"))

    private fun getPage(
        pageable: Pageable,
        query: JPAQuery<PersonEntity>
    ): Page<PersonEntity> =
        PageableExecutionUtils.getPage(
            queryDsl.applyPagination(pageable, query).fetch(),
            pageable,
            query.distinct()::fetchCount
        )

    override fun findByFilter(params: PersonFilter, pageable: Pageable): Page<Person> {
        val predicate = personFilterBuilder.build(
            params = params,
        )
        val query = JPAQuery<PersonEntity>(entityManager)
            .select(personEntity)
            .from(personEntity)
            .join(documentEntity).on(documentEntity.persons.contains(personEntity)).fetchJoin()
            .join(settlementEntity).on(settlementEntity.persons.contains(personEntity)).fetchJoin()
            .join(houseHoldEntity).on(houseHoldEntity.persons.contains(personEntity)).fetchJoin()
            .where(predicate)
            .groupBy(personEntity)

        val x = getPage(pageable, query) as Page<Person>
        return x
    }

}