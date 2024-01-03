package genealogy.domain.document.crud

import genealogy.domain.document.Document
import genealogy.domain.utils.command.Command

/** Команда сохранения документа */
class SaveDocumentCommand(
    val document: Document
): Command<Unit>