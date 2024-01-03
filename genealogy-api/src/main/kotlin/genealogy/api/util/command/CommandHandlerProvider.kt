package genealogy.api.util.command

import genealogy.domain.utils.command.Command
import genealogy.domain.utils.command.CommandHandler
import org.springframework.context.ApplicationContext

/** Провайдер обработчиков команд */
class CommandHandlerProvider<H: CommandHandler<Command<*>, *>>(
    private val context: ApplicationContext,
    private val type: Class<H>
) {
    /** Получение обработчика команд из контекста */
    fun getCommandHandler(): H =
        context.getBean(type)
}
