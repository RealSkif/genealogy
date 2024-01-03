package genealogy.api.settlement.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.settlement.crud.SaveSettlementsCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды сохранения населенных пунктов */
@Handler
class SaveSettlementsCommandHandler(
    private val saveSettlementUseCase: SaveSettlementUseCase
) : CommandHandler<SaveSettlementsCommand, Unit> {
    override fun handle(command: SaveSettlementsCommand) {
        saveSettlementUseCase.execute(command.settlements)
    }
}