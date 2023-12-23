package genealogy.data.village

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface VillageJpaRepository: JpaRepository<VillageEntity, UUID> {
}