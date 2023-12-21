package genealogy.data.person

import genealogy.domain.person.Person
import genealogy.domain.person.PersonRepository
import org.springframework.stereotype.Repository

/**
 * Репозиторий для работы с людьми
 */
@Repository
class PersonRepositoryImpl(
    private val personJpaRepository: PersonJpaRepository
) : PersonRepository {
    override fun findAll(): Collection<Person> =
        personJpaRepository.findAll()

}