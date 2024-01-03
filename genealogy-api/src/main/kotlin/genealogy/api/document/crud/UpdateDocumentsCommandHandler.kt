package genealogy.api.document.crud

import genealogy.domain.document.crud.UpdateDocumentsCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды обновления документов */
class UpdateDocumentsCommandHandler(
    private val updateDocumentUseCase: UpdateDocumentUseCase
) : CommandHandler<UpdateDocumentsCommand, Unit> {
    override fun handle(command: UpdateDocumentsCommand) {
        updateDocumentUseCase.execute(command.documents)
    }
}