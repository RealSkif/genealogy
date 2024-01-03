package genealogy.api.document.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.document.crud.UpdateDocumentCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды обновления документа */
@Handler
class UpdateDocumentCommandHandler(
    private val updateDocumentUseCase: UpdateDocumentUseCase
) : CommandHandler<UpdateDocumentCommand, Unit> {
    override fun handle(command: UpdateDocumentCommand) {
        updateDocumentUseCase.execute(command.document)
    }
}