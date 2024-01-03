package genealogy.api.document.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.document.crud.SaveDocumentCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды сохранения документа */
@Handler
class SaveDocumentCommandHandler(
private val saveDocumentUseCase: SaveDocumentUseCase
): CommandHandler<SaveDocumentCommand, Unit> {
    override fun handle(command: SaveDocumentCommand) =
        saveDocumentUseCase.execute(command.document)
}