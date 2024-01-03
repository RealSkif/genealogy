package genealogy.api.household.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.houshold.crud.UpdateHouseHoldsCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды обновления дворов */
@Handler
class UpdateHouseHoldsCommandHandler(
    private val updateHouseHoldUseCase: UpdateHouseHoldUseCase
) : CommandHandler<UpdateHouseHoldsCommand, Unit> {
    override fun handle(command: UpdateHouseHoldsCommand) {
        updateHouseHoldUseCase.execute(command.houseHolds)
    }
}