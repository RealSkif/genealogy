
/**
 * Шина запросов
 */
interface QueryBus {
    /**
     * Выполнение запроса
     */
    fun <Q: Query<R>, R> execute(query: Q): R
}
