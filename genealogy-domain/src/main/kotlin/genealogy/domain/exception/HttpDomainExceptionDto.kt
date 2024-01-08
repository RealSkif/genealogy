package genealogy.domain.exception

import genealogy.domain.exception.CustomExceptionProperties.DEFAULT_DESCRIPTION
import org.springframework.http.HttpStatus

/**
 * Формат ответа при исключении
 */
data class HttpDomainExceptionDto(
    val exception: String,
    val message: String,
    val description: String? = null,
    val nestedExceptions: MutableList<HttpDomainExceptionDto> = mutableListOf(),
    val initCause: Throwable? = null,
    val status: HttpStatus
) {

    constructor(
        exception: Any,
        message: String?,
        description: String? = null,
        status: HttpStatus,
        nestedExceptions: MutableList<HttpDomainExceptionDto> = mutableListOf()
    ) : this(
        exception = exception.javaClass.name,
        message = message ?: "Domain exception has occurred",
        description = description ?: DEFAULT_DESCRIPTION,
        initCause = null,
        status = status,
        nestedExceptions = nestedExceptions
    )

    constructor(responseException: HttpDomainException, withDescription: Boolean = true) : this(
        exception = responseException.exception ?: responseException.javaClass.name,
        message = responseException.message ?: "Domain exception has occurred",
        description = responseException.description
            ?: (if (withDescription && responseException.nestedExceptions.isEmpty()) DEFAULT_DESCRIPTION else null),
        nestedExceptions = responseException.nestedExceptions
            .filterIsInstance<HttpDomainException>()
            .map { HttpDomainExceptionDto(it, false) }
            .toMutableList(),
        status = responseException.status ?: CustomExceptionProperties.status
    )
}