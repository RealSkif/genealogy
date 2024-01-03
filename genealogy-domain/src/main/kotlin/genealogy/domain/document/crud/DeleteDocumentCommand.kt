package genealogy.domain.document.crud

import genealogy.domain.utils.command.Command
import java.util.UUID

/** Команда удаления документа */
class DeleteDocumentCommand(
    val documentId: UUID
) : Command<Unit>