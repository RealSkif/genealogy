package genealogy.api.util.query

import genealogy.domain.utils.query.Query
import genealogy.domain.utils.query.QueryHandler
import genealogy.domain.utils.query.QueryRegistry
import org.springframework.context.ApplicationContext
import org.springframework.core.GenericTypeResolver
import org.springframework.stereotype.Component

/** Провайдер реестра обработчиков запросов */
@Component
class QueryRegistryProvider(
    private val context: ApplicationContext
) : QueryRegistry {

    /**
     * Карта обработчиков запросов
     */
    private val queryHandlerProviderMap:
            MutableMap<Class<out Query<*>>, QueryHandlerProvider<QueryHandler<Query<*>, *>>> = mutableMapOf()

    init {
        registerQueryHandlers()
    }

    /** Поиск и регистрация обработчиков запросов */
    private fun registerQueryHandlers() {
        // ищем обработчики запросов в бинах
        context.getBeanNamesForType(QueryHandler::class.java)
            .forEach {
                registerQuery(context, it)
            }
    }

    /** Регистрация обработчика запроса */
    @Suppress("UNCHECKED_CAST")
    private fun registerQuery(context: ApplicationContext, name: String) {
        val handlerClass: Class<QueryHandler<Query<*>, *>> = context.getType(name) as Class<QueryHandler<Query<*>, *>>
        val generics: Array<Class<*>> =
            GenericTypeResolver.resolveTypeArguments(handlerClass, QueryHandler::class.java)!!
        val queryType: Class<out Query<*>> = generics.first() as Class<out Query<*>>
        queryHandlerProviderMap[queryType] = QueryHandlerProvider(context = context, type = handlerClass)
    }

    /** Получение обработчика команды */
    @Suppress("UNCHECKED_CAST")
    override fun <Q : Query<T>, T> getQueryHandler(queryClass: Class<Q>): QueryHandler<Q, T> =
        queryHandlerProviderMap[queryClass]
            ?.getQueryHandler() as? QueryHandler<Q, T>
            ?: throw RuntimeException("Обработчик запроса ${queryClass.name} не найден")

}
