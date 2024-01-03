package genealogy.api.household.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.document.crud.DeleteDocumentCommand
import genealogy.domain.houshold.crud.DeleteHouseHoldCommand
import genealogy.domain.utils.command.CommandHandler


/** Обработчик команды удаления двора */
@Handler
class DeleteHouseHoldCommandHandler(
    private val deleteHouseHoldUseCase: DeleteHouseHoldUseCase
) : CommandHandler<DeleteHouseHoldCommand, Unit> {
    override fun handle(command: DeleteHouseHoldCommand) {
        deleteHouseHoldUseCase.execute(command.houseHoldId)
    }
}