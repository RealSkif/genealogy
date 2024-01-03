package genealogy.api.person.crud

import genealogy.api.util.stereotype.UseCase
import genealogy.domain.person.Person
import genealogy.domain.person.PersonRepository

/** Сохранение людей */
@UseCase
class SavePersonUseCase(
    private val personRepository: PersonRepository
) {

    /** Сохранение человека
     *
     * @param person Сохраняемый человек
     */
    fun execute(person: Person) {
        val existingPerson: Person? = personRepository.findByFullName(person)
        if (existingPerson == null)
            personRepository.save(person)
    }

    /** Сохранение людей
     *
     * @param persons Сохраняемые люди
     */
    fun execute(persons: Collection<Person>) {
        val existingPersons: MutableList<Person> = mutableListOf()
        persons.forEach {
            val foundPerson = personRepository.findByFullName(it)
            if (foundPerson != null)
                existingPersons.add(foundPerson)
        }
        persons.filter { !it.compareByFullName(existingPersons) }
        personRepository.saveAll(persons)
    }
}