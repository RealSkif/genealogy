package genealogy.api.settlement.crud

import genealogy.api.util.stereotype.UseCase
import genealogy.domain.settlement.Settlement
import genealogy.domain.settlement.SettlementRepository

/** Обработчик команды обновления населенных пунктов */
@UseCase
class UpdateSettlementUseCase(
    private val settlementRepository: SettlementRepository
) {
    /** Обновление населенного пункта
     *
     * @param settlement Обновляемый населенный пункт
     */
    fun execute(settlement: Settlement) {
        settlementRepository.save(settlement)
    }

    /** Обновление населенных пунктов
     *
     * @param settlements Обновляемые населенные пункты
     */
    fun execute(settlements: Collection<Settlement>) {
        settlementRepository.saveAll(settlements)
    }
}