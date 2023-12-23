package genealogy.data.person

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PersonJpaRepository: JpaRepository<PersonEntity, UUID> {
}