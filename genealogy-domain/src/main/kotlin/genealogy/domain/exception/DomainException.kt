package genealogy.domain.exception

import genealogy.domain.exception.ExceptionUtils.stackTraceAndMessage
import org.springframework.http.HttpStatus

/**
 * Базовый класс исключения
 */
abstract class DomainException(
    /**
     * Описание ошибки
     */
    var description: String? = null,

    /**
     * Алиас ошибки
     */
    open var exception: String? = null,

    /**
     * Сообщение об ошибке
     */
    override val message: String? = null,

    /**
     * Коллекция описаний ошибок
     */
    var descriptionList: List<String?> = listOf(),

    /**
     * Вложенные ошибки предметной области, на основании которых произошла текущая ошибка
     */
    open var nestedExceptions: MutableList<DomainException> = mutableListOf(),

    /**
     * Исключение, причиной которого стала текущая ошибка
     */
    open var initCause: Throwable? = null,

    /**
     * Статус http ответа
     */
    open val status: HttpStatus? = null

) : RuntimeException(message) {

    constructor(description: String) : this(
        exception = null,
        message = null,
        description = description
    )

    val descriptionExtended: String?
        get() = description +
                (nestedExceptions.mapNotNull { it.description }
                    .takeIf { it.isNotEmpty() }
                    ?.joinToString(", ", " (", ")")
                    ?: "")

    /**
     * Вывести сообщение и стек вызова исключения
     * @param delimiter разделитель
     */
    fun stackDescription(delimiter: String = StringPool.SPACE, isStart: Boolean = true): String =
        buildString {
            description?.let {
                if (!isStart) {
                    append(delimiter)
                }
                append(it)
            }
            nestedExceptions.forEach { ex ->
                ex.stackDescription(delimiter = delimiter, isStart = false)
            }
        }


    /**
     * Вывести сообщение и стек вызова исключения
     */
    fun stackTraceDescriptionMessage(isStart: Boolean = true): String =
        buildString {

            if (!isStart) {
                append(StringPool.RETURN_NEW_LINE)
            }
            description?.let {
                append(it)
                append(StringPool.RETURN_NEW_LINE)
            }
            append(stackTraceAndMessage(isStart = false))
            nestedExceptions.forEach { ex ->
                append(ex.stackTraceDescriptionMessage(isStart = false))
            }
        }

}