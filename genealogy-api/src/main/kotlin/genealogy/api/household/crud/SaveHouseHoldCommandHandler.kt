package genealogy.api.household.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.houshold.crud.SaveHouseHoldCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды сохранения двора */
@Handler
class SaveHouseHoldCommandHandler(
private val saveHouseHoldUseCase: SaveHouseHoldUseCase
): CommandHandler<SaveHouseHoldCommand, Unit> {
    override fun handle(command: SaveHouseHoldCommand) =
        saveHouseHoldUseCase.execute(command.houseHold)
}