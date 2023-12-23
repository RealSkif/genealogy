package genealogy.api.util.query

import genealogy.domain.utils.query.Query
import genealogy.domain.utils.query.QueryBus
import genealogy.domain.utils.query.QueryRegistry
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

/**
 * Провайдер шины запросов
 */
@Component
class QueryBusProvider(
    private val registry: QueryRegistry
) : QueryBus {

    /**
     * Выполнение запроса
     */
    @Suppress("UNCHECKED_CAST")
    @Transactional(propagation = Propagation.MANDATORY, readOnly = true)
    override fun <Q : Query<T>, T> execute(query: Q): T =
        registry.getQueryHandler(query.javaClass)
            .handle(query)
}