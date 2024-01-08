package genealogy.api.person

import genealogy.api.util.stereotype.UseCase
import genealogy.domain.person.Person
import genealogy.domain.person.PersonFilter
import genealogy.domain.person.PersonRepository
import genealogy.domain.utils.PageContent
import org.springframework.data.domain.Page

@UseCase
class FindPersonsByFilterUseCase(
    private val personRepository: PersonRepository
) {
    fun execute(personFilter: PersonFilter): Page<Person> =
        personRepository.findByFilter(personFilter)!!
}