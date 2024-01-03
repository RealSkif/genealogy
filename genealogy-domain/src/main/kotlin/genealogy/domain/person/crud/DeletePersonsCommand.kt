package genealogy.domain.person.crud

import genealogy.domain.utils.command.Command
import java.util.UUID

/** Команда удаления людей */
class DeletePersonsCommand(
    val personIds: Collection<UUID>
) : Command<Unit>