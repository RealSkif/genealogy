package genealogy.api.person.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.person.crud.UpdatePersonsCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды обновления людей */
@Handler
class UpdatePersonsCommandHandler(
    private val updatePersonUseCase: UpdatePersonUseCase
) : CommandHandler<UpdatePersonsCommand, Unit> {
    override fun handle(command: UpdatePersonsCommand) {
        updatePersonUseCase.execute(command.persons)
    }
}