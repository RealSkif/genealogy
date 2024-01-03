package genealogy.domain.utils.command

/** Реестр обработчиков команд */
interface CommandRegistry {

    /** Получение обработчика команды */
    fun <C : Command<R>, R> getCommandHandler(commandClass: Class<C>): CommandHandler<C, R>
}
