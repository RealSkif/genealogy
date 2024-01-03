package genealogy.api.person.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.person.crud.SavePersonsCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды сохранения людей */
@Handler
class SavePersonsCommandHandler(
    private val savePersonUseCase: SavePersonUseCase
) : CommandHandler<SavePersonsCommand, Unit> {
    override fun handle(command: SavePersonsCommand) {
        savePersonUseCase.execute(command.persons)
    }
}