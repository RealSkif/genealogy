package genealogy.domain.document.crud

import genealogy.domain.utils.command.Command
import java.util.UUID

/** Команда удаления документов */
class DeleteDocumentsCommand(
    val documentIds: Collection<UUID>
) : Command<Unit>