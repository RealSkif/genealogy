package genealogy.api.person.crud

import genealogy.api.util.stereotype.UseCase
import genealogy.domain.person.Person
import genealogy.domain.person.PersonRepository

/** Обновление людей */
@UseCase
class UpdatePersonUseCase(
    private val personRepository: PersonRepository
) {

    /** Обновление человека
     *
     * @param person Обновляемый человек
     */
    fun execute(person: Person) {
        personRepository.save(person)
    }

    /** Обновление людей
     *
     * @param persons Обновляемые люди
     */
    fun execute(persons: Collection<Person>) {
        personRepository.saveAll(persons)
    }
}