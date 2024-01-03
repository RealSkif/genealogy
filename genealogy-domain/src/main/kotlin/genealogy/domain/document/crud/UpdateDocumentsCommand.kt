package genealogy.domain.document.crud

import genealogy.domain.document.Document
import genealogy.domain.utils.command.Command

/** Команда обновления документов */
class UpdateDocumentsCommand(
    val documents: Collection<Document>
):Command<Unit> {
}