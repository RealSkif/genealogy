package genealogy.data.person

import genealogy.domain.person.Person
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PersonJpaRepository: JpaRepository<Person, UUID> {
}