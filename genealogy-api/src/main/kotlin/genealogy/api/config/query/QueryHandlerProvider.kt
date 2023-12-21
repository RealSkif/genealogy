
import org.springframework.context.ApplicationContext

/**
 * Провайдер обработчиков команд
 */
class QueryHandlerProvider<H : QueryHandler<Query<*>, *>>(
    private val context: ApplicationContext,
    private val type: Class<H>
) {
    /**
     * Получение обработчика запроса из контекста
     */
    fun getQueryHandler(): H =
        context.getBean(type)
}