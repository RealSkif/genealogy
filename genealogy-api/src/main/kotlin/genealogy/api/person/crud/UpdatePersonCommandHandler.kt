package genealogy.api.person.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.person.crud.UpdatePersonCommand
import genealogy.domain.utils.command.CommandHandler

/** Обработчик команды обновления человека */
@Handler
class UpdatePersonCommandHandler(
    private val updatePersonUseCase: UpdatePersonUseCase
) : CommandHandler<UpdatePersonCommand, Unit> {
    override fun handle(command: UpdatePersonCommand) {
        updatePersonUseCase.execute(command.person)
    }
}