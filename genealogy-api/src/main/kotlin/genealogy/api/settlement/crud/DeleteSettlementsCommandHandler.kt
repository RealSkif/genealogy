package genealogy.api.settlement.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.settlement.crud.DeleteSettlementsCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды удаления населенных пунктов */
@Handler
class DeleteSettlementsCommandHandler(
    private val deleteSettlementUseCase: DeleteSettlementUseCase
) : CommandHandler<DeleteSettlementsCommand, Unit> {
    override fun handle(command: DeleteSettlementsCommand) {
        deleteSettlementUseCase.execute(command.settlementIds)
    }
}