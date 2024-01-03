package genealogy.api.settlement.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.settlement.crud.UpdateSettlementsCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды обновления населенных пунктов */
@Handler
class UpdateSettlementsCommandHandler(
    private val updateSettlementUseCase: UpdateSettlementUseCase
) : CommandHandler<UpdateSettlementsCommand, Unit> {
    override fun handle(command: UpdateSettlementsCommand) {
        updateSettlementUseCase.execute(command.settlements)
    }
}