package genealogy.api.person.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.document.crud.DeleteDocumentCommand
import genealogy.domain.person.crud.DeletePersonCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды удаления человека */
@Handler
class DeletePersonCommandHandler(
    private val deletePersonUseCase: DeletePersonUseCase
) : CommandHandler<DeletePersonCommand, Unit> {
    override fun handle(command: DeletePersonCommand) {
        deletePersonUseCase.execute(command.personId)
    }
}