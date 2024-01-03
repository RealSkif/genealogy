package genealogy.domain.person.crud

import genealogy.domain.person.Person
import genealogy.domain.utils.command.Command

/** Команда обновления людей */
class UpdatePersonsCommand(
    val persons: Collection<Person>
) : Command<Unit>