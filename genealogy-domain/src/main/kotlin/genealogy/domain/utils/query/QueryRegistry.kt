
/**
 * Реестр запросов
 */
interface QueryRegistry {
    /**
     * Получение обработчика запросов
     */
    fun <Q: Query<R>, R> getQueryHandler(queryClass: Class<Q>): QueryHandler<Q, R>
}
