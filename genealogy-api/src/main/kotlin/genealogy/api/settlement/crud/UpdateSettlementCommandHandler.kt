package genealogy.api.settlement.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.settlement.crud.UpdateSettlementCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды обновления населенного пункта */
@Handler
class UpdateSettlementCommandHandler(
    private val updateSettlementUseCase: UpdateSettlementUseCase
) : CommandHandler<UpdateSettlementCommand, Unit> {
    override fun handle(command: UpdateSettlementCommand) {
        updateSettlementUseCase.execute(command.settlement)
    }
}