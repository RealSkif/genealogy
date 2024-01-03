package genealogy.data.settlement

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SettlementJpaRepository : JpaRepository<SettlementEntity, UUID> {
    fun findBySettlementName(settlementName: String): SettlementEntity?
    fun findBySettlementNameIn(settlementNames: Collection<String>): Collection<SettlementEntity>?
}