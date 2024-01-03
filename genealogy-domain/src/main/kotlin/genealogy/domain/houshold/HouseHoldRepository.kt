package genealogy.domain.houshold

import genealogy.domain.document.Document
import java.util.*

/** Интерфейс репозитория для работы с дворами */
interface HouseHoldRepository {

    fun save(houseHold: HouseHold)
    fun saveAll(houseHolds: Collection<HouseHold>)
    fun delete(houseHoldId: UUID)
    fun deleteBatch(houseHoldIds: Collection<UUID>)
    fun findByHouseHoldNumber(houseHoldNumber: Int): HouseHold?
    fun findByHouseHoldNumber(houseHoldNumbers: Collection<Int>): Collection<HouseHold>?
    fun findAll(): Collection<HouseHold>
}