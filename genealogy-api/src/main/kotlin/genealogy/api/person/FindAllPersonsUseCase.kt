
package genealogy.api.person

import genealogy.api.util.stereotype.UseCase
import genealogy.domain.person.Person
import genealogy.domain.person.PersonRepository

@UseCase
class FindAllPersonsUseCase(
    private val personRepository: PersonRepository
) {

    fun execute(): Collection<Person> =
        personRepository.findAll()
}