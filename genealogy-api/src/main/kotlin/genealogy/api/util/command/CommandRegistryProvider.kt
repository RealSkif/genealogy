package genealogy.api.util.command

import genealogy.domain.utils.command.Command
import genealogy.domain.utils.command.CommandHandler
import genealogy.domain.utils.command.CommandRegistry
import org.springframework.context.ApplicationContext
import org.springframework.core.GenericTypeResolver
import org.springframework.stereotype.Component

/** Провайдер реестра обработчиков команд */
@Component
class CommandRegistryProvider(
    private val context: ApplicationContext
) : CommandRegistry {

    /** Карта обработчиков команд */
    private val commandHandlerProviderMap: MutableMap<Class<out Command<*>>,
            CommandHandlerProvider<CommandHandler<Command<*>, *>>> = mutableMapOf()

    init {
        registerCommandHandlers()
    }

    /** Поиск и регистрация обработчиков команд */
    private fun registerCommandHandlers() {
        // ищем обработчики команд в бинах
        context.getBeanNamesForType(CommandHandler::class.java)
            .forEach {
                registerCommand(context, it)
            }
    }

    /** Регистрация обработчика команды */
    @Suppress("UNCHECKED_CAST")
    private fun registerCommand(context: ApplicationContext, name: String) {
        val handlerClass: Class<CommandHandler<Command<*>, *>> =
            context.getType(name) as Class<CommandHandler<Command<*>, *>>
        val generics: Array<Class<*>> =
            GenericTypeResolver.resolveTypeArguments(handlerClass, CommandHandler::class.java)!!
        val commandType: Class<out Command<*>> = generics.first() as Class<out Command<*>>
        commandHandlerProviderMap[commandType] = CommandHandlerProvider(context = context, type = handlerClass)
    }

    /** Получение обработчика команды */
    @Suppress("UNCHECKED_CAST")
    override fun <C : Command<T>, T> getCommandHandler(commandClass: Class<C>): CommandHandler<C, T> =
        commandHandlerProviderMap[commandClass]
            ?.getCommandHandler() as? CommandHandler<C, T>
            ?: throw RuntimeException("Обработчик для команды ${commandClass.name} не найден")
}
