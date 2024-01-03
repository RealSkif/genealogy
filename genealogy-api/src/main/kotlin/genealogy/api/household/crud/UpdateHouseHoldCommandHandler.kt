package genealogy.api.household.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.houshold.crud.UpdateHouseHoldCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды обновления двора */
@Handler
class UpdateHouseHoldCommandHandler(
    private val updateHouseHoldUseCase: UpdateHouseHoldUseCase
) : CommandHandler<UpdateHouseHoldCommand, Unit> {
    override fun handle(command: UpdateHouseHoldCommand) {
        updateHouseHoldUseCase.execute(command.houseHold)
    }
}