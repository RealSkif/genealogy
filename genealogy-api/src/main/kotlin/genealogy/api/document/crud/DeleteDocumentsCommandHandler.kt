package genealogy.api.document.crud

import genealogy.domain.document.crud.DeleteDocumentsCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды удаления документов */
class DeleteDocumentsCommandHandler(
    private val deleteDocumentUseCase: DeleteDocumentUseCase
) : CommandHandler<DeleteDocumentsCommand, Unit> {
    override fun handle(command: DeleteDocumentsCommand) {
        deleteDocumentUseCase.execute(command.documentIds)
    }
}