
/**
 * Обработчик команды
 */
interface CommandHandler<C: Command<R>, R> {
    /**
     * Обработка команды
     */
    fun handle(command: C): R
}
