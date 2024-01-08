package genealogy.domain.exception

import org.springframework.http.HttpStatus

/**
 * Исключение, возникающее при ошибке при обработке http-запроса
 */
open class HttpDomainException(
    description: String? = null,
    message: String? = null,
    nestedExceptions: MutableList<DomainException> = mutableListOf(),
    initCause: Throwable? = null,
    exception: String? = null,
    descriptionList: List<String?> = listOf(),
    status: HttpStatus = CustomExceptionProperties.status
) : DomainException(
    exception = exception,
    message = message,
    nestedExceptions = nestedExceptions,
    initCause = initCause,
    description = description,
    descriptionList = descriptionList,
    status = status
) {
    constructor(exception: DomainException): this(
        description = exception.description,
        message = exception.message,
        nestedExceptions = exception.nestedExceptions.map { HttpDomainException(it) }.toMutableList(),
        initCause = exception.cause,
        status = exception.status ?: CustomExceptionProperties.status
    )

    constructor(exception: HttpDomainExceptionDto): this(
        description = exception.description,
        message = exception.message,
        nestedExceptions = exception.nestedExceptions.map { HttpDomainException(it) }.toMutableList(),
        initCause = exception.initCause,
        status = exception.status,
        exception = exception.exception
    )
}