package genealogy.api.settlement.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.settlement.crud.SaveSettlementCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды сохранения населенного пункта */
@Handler
class SaveSettlementCommandHandler(
    private val saveSettlementUseCase: SaveSettlementUseCase
) : CommandHandler<SaveSettlementCommand, Unit> {
    override fun handle(command: SaveSettlementCommand) =
        saveSettlementUseCase.execute(command.settlement)
}