package genealogy.data.person

import genealogy.domain.person.Person
import genealogy.domain.person.PersonFilter
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable


interface PersonJpaRepositoryExtension {

    fun findByFilter(params: PersonFilter, pageable: Pageable): Page<Person>
}