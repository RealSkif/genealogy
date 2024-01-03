package genealogy.api.settlement.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.settlement.crud.DeleteSettlementCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды удаления населенного пункта */
@Handler
class DeleteSettlementCommandHandler(
    private val deleteSettlementUseCase: DeleteSettlementUseCase
) : CommandHandler<DeleteSettlementCommand, Unit> {
    override fun handle(command: DeleteSettlementCommand) {
        deleteSettlementUseCase.execute(command.settlementId)
    }
}