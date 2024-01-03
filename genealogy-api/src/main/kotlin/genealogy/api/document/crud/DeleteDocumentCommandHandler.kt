package genealogy.api.document.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.document.crud.DeleteDocumentCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды удаления документа */
@Handler
class DeleteDocumentCommandHandler(
    private val deleteDocumentUseCase: DeleteDocumentUseCase
) : CommandHandler<DeleteDocumentCommand, Unit> {
    override fun handle(command: DeleteDocumentCommand) {
        deleteDocumentUseCase.execute(command.documentId)
    }
}