package genealogy.domain.person.crud

import genealogy.domain.person.Person
import genealogy.domain.settlement.Settlement
import genealogy.domain.utils.command.Command

/** Команда сохранения человека */
class SavePersonCommand(
    val person: Person
): Command<Unit> {
}