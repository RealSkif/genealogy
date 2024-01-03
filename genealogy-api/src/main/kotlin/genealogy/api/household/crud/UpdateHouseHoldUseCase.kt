package genealogy.api.household.crud

import genealogy.api.util.stereotype.UseCase
import genealogy.domain.houshold.HouseHold
import genealogy.domain.houshold.HouseHoldRepository

/** Обновления двора */
@UseCase
class UpdateHouseHoldUseCase(
    private val houseHoldRepository: HouseHoldRepository
) {
    /** Обновление двора
     *
     * @param houseHold Обновляемый двор
     */
    fun execute(houseHold: HouseHold) {
        houseHoldRepository.save(houseHold)
    }

    /** Обновление двора
     *
     * @param houseHolds Обновляемые дворы
     */
    fun execute(houseHolds: Collection<HouseHold>) {
        houseHoldRepository.saveAll(houseHolds)
    }
}