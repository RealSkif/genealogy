package genealogy.domain.person.crud

import genealogy.domain.utils.command.Command
import java.util.UUID

/** Команда удаления человека */
class DeletePersonCommand(
    val personId: UUID
) : Command<Unit>