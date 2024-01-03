package genealogy.domain.person.crud

import genealogy.domain.person.Person
import genealogy.domain.settlement.Settlement
import genealogy.domain.utils.command.Command

/** Команда обновления человека */
class UpdatePersonCommand(
    val person: Person
): Command<Unit>