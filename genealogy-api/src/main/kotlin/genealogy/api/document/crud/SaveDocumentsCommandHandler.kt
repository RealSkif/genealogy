package genealogy.api.document.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.document.crud.SaveDocumentsCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды сохранения документов */
@Handler
class SaveDocumentsCommandHandler(
    private val saveDocumentUseCase: SaveDocumentUseCase
) : CommandHandler<SaveDocumentsCommand, Unit> {
    override fun handle(command: SaveDocumentsCommand) {
        saveDocumentUseCase.execute(command.documents)
    }
}