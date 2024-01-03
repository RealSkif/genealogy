package genealogy.api.util.command

import genealogy.domain.utils.command.Command
import genealogy.domain.utils.command.CommandBus
import genealogy.domain.utils.command.CommandRegistry
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

/** Провайдер шина для передачи команд */
@Component
class CommandBusProvider(
    private val registry: CommandRegistry
) : CommandBus {

    /** Транзакция выполнения команды */
    @Transactional(propagation = Propagation.MANDATORY)
    override fun <C : Command<T>, T> execute(command: C): T =
        registry.getCommandHandler(command.javaClass)
            .handle(command)
}
