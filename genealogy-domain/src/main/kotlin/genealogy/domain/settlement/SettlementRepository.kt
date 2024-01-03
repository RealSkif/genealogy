package genealogy.domain.settlement

import genealogy.domain.document.Document
import java.util.*

/** Интерфейс репозитория для работы с поселениями */
interface SettlementRepository {
    fun save(settlement: Settlement)
    fun saveAll(settlements: Collection<Settlement>)
    fun delete(settlementId: UUID)
    fun deleteBatch(settlementIds: Collection<UUID>)
    fun findBySettlementName(settlementName: String): Settlement?
    fun findBySettlementName(settlementNames: Collection<String>): Collection<Settlement>?
    fun findAll(): Collection<Settlement>
}