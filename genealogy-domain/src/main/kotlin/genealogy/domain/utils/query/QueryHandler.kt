package genealogy.domain.utils.query


/** Обработчик запроса */
interface QueryHandler<Q : Query<R>, R> {

    /** Обработка запроса */
    fun handle(query: Q): R
}
