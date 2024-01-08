package genealogy.data.person

import com.querydsl.core.types.Predicate
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import java.util.*

interface PersonJpaRepository :
    JpaRepository<PersonEntity, UUID>,
    QuerydslPredicateExecutor<PersonEntity>,
    PersonJpaRepositoryExtension {

    //TODO: Временный метод, пока не найдется более точный способ идентифицировать нового человека
    fun findByFirstNameAndSecondNameAndMiddleName(
        firstName: String,
        secondName: String,
        middleName: String
    ): PersonEntity?
//    @EntityGraph(attributePaths = ["documents"])
    override fun findAll(predicate: Predicate, pageable: Pageable): Page<PersonEntity>
}