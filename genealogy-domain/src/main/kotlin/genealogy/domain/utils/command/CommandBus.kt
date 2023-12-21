
/**
 * Шина для передачи команд
 */
interface CommandBus {
    /**
     * Выполнение команды
     */
    fun <C: Command<R>, R> execute(command: C): R
}