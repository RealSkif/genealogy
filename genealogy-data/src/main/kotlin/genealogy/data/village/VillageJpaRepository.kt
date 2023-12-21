package genealogy.data.village

import genealogy.domain.village.Village
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface VillageJpaRepository: JpaRepository<Village, UUID> {
}