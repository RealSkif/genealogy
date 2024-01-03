package genealogy.domain.document.crud

import genealogy.domain.document.Document
import genealogy.domain.utils.command.Command

/** Команда обновления документа */
class UpdateDocumentCommand(
    val document: Document
) : Command<Unit>