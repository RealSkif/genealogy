package genealogy.domain.person

import org.springframework.data.domain.Page
import java.util.*

/** Репозиторий для работы с людьми */
interface PersonRepository {
    fun save(person: Person)
    fun saveAll(persons: Collection<Person>)
    fun delete(personId: UUID)
    fun deleteBatch(personIds: Collection<UUID>)
    fun findByFullName(person: Person): Person?
    fun findByFullName(persons: Collection<Person>): Collection<Person>?
    fun findAll(): Collection<Person>
    fun findByFilter(personFilter: PersonFilter): Page<Person>?
}