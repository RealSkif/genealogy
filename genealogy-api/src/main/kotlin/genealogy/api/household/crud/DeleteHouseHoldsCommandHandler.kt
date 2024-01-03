package genealogy.api.household.crud

import genealogy.domain.houshold.crud.DeleteHouseHoldsCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды удаления дворов */
class DeleteHouseHoldsCommandHandler(
    private val deleteHouseHoldUseCase: DeleteHouseHoldUseCase
) : CommandHandler<DeleteHouseHoldsCommand, Unit> {
    override fun handle(command: DeleteHouseHoldsCommand) {
        deleteHouseHoldUseCase.execute(command.houseHoldIds)
    }
}