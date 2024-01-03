package genealogy.api.household.crud

import genealogy.api.util.stereotype.UseCase
import genealogy.domain.houshold.HouseHold
import genealogy.domain.houshold.HouseHoldRepository

/** Сохранение дворов */
@UseCase
class SaveHouseHoldUseCase(
    private val houseHoldRepository: HouseHoldRepository
) {

    /** Сохранение двора
     *
     * @param houseHold Документ для сохранения
     */
    fun execute(houseHold: HouseHold) {
        val existingDocument: HouseHold? = houseHoldRepository.findByHouseHoldNumber(houseHold.houseHoldNumber)
        if (existingDocument == null)
            houseHoldRepository.save(houseHold)
    }

    /** Сохранение дворов
     *
     * @param houseHolds Сохраняемые дворы
     */
    fun execute(houseHolds: Collection<HouseHold>) {
        var existingHouseHoldsNumbers: Collection<Int> = listOf()
        val existingHouseHolds = houseHoldRepository.findByHouseHoldNumber(houseHolds.map { it.houseHoldNumber })
        if (existingHouseHolds != null)
            existingHouseHoldsNumbers = existingHouseHolds.map { it.houseHoldNumber }
        //TODO: Поиск и сравнение по номеру двора может вызвать коллизии
        val documentsToSave = houseHolds.filter { !existingHouseHoldsNumbers.contains(it.houseHoldNumber) }
        houseHoldRepository.saveAll(documentsToSave)
    }
}