package genealogy.api.household.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.houshold.crud.SaveHouseHoldsCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды сохранения дворов */
@Handler
class SaveHouseHoldsCommandHandler(
    private val saveHouseHoldUseCase: SaveHouseHoldUseCase
) : CommandHandler<SaveHouseHoldsCommand, Unit> {
    override fun handle(command: SaveHouseHoldsCommand) {
        saveHouseHoldUseCase.execute(command.houseHolds)
    }
}