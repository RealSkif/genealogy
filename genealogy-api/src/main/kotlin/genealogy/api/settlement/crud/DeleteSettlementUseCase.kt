package genealogy.api.settlement.crud

import genealogy.api.util.stereotype.UseCase
import genealogy.domain.settlement.SettlementRepository
import java.util.UUID

/** Удаления населенных пунктов */
@UseCase
class DeleteSettlementUseCase(
    private val settlementRepository: SettlementRepository
) {

    /** Удаление населенного пункта
     *
     * @param settlementId Обновляемый человек
     */
    fun execute(settlementId: UUID) {
        settlementRepository.delete(settlementId)
    }

    /** Удаление населенных пунктов
     *
     * @param settlementIds Обновляемый человек
     */
    fun execute(settlementIds: Collection<UUID>) {
        settlementRepository.deleteBatch(settlementIds)
    }
}
