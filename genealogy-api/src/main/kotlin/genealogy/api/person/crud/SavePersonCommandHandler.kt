package genealogy.api.person.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.person.crud.SavePersonCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды сохранения человека */
@Handler
class SavePersonCommandHandler(
private val savePersonUseCase: SavePersonUseCase
): CommandHandler<SavePersonCommand, Unit> {
    override fun handle(command: SavePersonCommand) =
        savePersonUseCase.execute(command.person)
}