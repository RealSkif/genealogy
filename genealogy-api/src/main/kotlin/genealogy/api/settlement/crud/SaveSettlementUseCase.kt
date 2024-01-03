package genealogy.api.settlement.crud

import genealogy.api.util.stereotype.UseCase
import genealogy.domain.settlement.Settlement
import genealogy.domain.settlement.SettlementRepository

/** Сохранение населенного пункта */
@UseCase
class SaveSettlementUseCase(
    private val settlementRepository: SettlementRepository
) {
    /** Сохранение населенного пункта
     *
     * @param settlement Населенный пункт для сохранения
     */
    fun execute(settlement: Settlement) {
        val existingSettlement: Settlement? =
            settlementRepository.findBySettlementName(settlement.settlementName)
        if (existingSettlement == null)
            settlementRepository.save(settlement)
    }

    /** Сохранение населенных пунктов
     *
     * @param settlements Населенные пункты для сохранения
     */
    fun execute(settlements: Collection<Settlement>) {
        var existingSettlementsNames: Collection<String> = listOf()
        val existingSettlements = settlementRepository.findBySettlementName(settlements.map { it.settlementName })
        if (existingSettlements != null)
            existingSettlementsNames = existingSettlements.map { it.settlementName }
        val documentsToSave = settlements.filter { !existingSettlementsNames.contains(it.settlementName) }
        settlementRepository.saveAll(documentsToSave)
    }
}