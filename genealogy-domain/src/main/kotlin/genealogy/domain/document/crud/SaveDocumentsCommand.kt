package genealogy.domain.document.crud

import genealogy.domain.document.Document
import genealogy.domain.utils.command.Command

/** Команда сохранения документов */
class SaveDocumentsCommand(
    val documents: Collection<Document>
): Command<Unit>