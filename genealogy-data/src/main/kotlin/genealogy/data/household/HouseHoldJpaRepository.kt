package genealogy.data.household

import genealogy.domain.houshold.HouseHold
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface HouseHoldJpaRepository: JpaRepository<HouseHoldEntity, UUID> {
}