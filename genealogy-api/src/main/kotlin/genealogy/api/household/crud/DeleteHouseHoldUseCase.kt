package genealogy.api.household.crud

import genealogy.api.util.stereotype.UseCase
import genealogy.domain.houshold.HouseHoldRepository
import java.util.UUID

/** Удаление двора */
@UseCase
class DeleteHouseHoldUseCase(
    private val houseHoldRepository: HouseHoldRepository
) {

    /** Удаление двора
     *
     * @param houseHoldId Идентификатор удаляемого двора
     */
    fun execute(houseHoldId: UUID) {
        houseHoldRepository.delete(houseHoldId)
    }

    /** Удаление двора
     *
     * @param houseHoldIds Идентификатор удаляемых дворов
     */
    fun execute(houseHoldIds: Collection<UUID>) {
        houseHoldRepository.deleteBatch(houseHoldIds)
    }
}