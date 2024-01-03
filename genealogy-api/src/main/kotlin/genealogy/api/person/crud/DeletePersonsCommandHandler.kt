package genealogy.api.person.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.person.crud.DeletePersonsCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды удаления людей */
@Handler
class DeletePersonsCommandHandler(
    private val deletePersonUseCase: DeletePersonUseCase
) : CommandHandler<DeletePersonsCommand, Unit> {
    override fun handle(command: DeletePersonsCommand) {
        deletePersonUseCase.execute(command.personIds)
    }
}