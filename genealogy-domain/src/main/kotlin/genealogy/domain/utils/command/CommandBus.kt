package genealogy.domain.utils.command

/**
 * Шина для передачи команд
 */
interface CommandBus {
    /**
     * Выполнение команды
     */
    fun <C: Command<R>, R> execute(command: C): R
}