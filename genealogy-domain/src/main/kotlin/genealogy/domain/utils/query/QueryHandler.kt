
/**
 * Обработчик запроса
 */
interface QueryHandler<Q: Query<R>, R> {
    /**
     * Обработка запроса
     */
    fun handle(query: Q): R
}
