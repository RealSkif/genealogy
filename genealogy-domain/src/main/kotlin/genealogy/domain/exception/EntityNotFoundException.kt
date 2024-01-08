package genealogy.domain.exception

import org.springframework.http.HttpStatus

/**
 * Исключение для http ошибок 404 статуса - запрашиваемый ресурс не найден
 */
open class EntityNotFoundException(
    message: String? = null,
    description: String? = null
) : HttpDomainException(
    status = HttpStatus.NOT_FOUND,
    message = message,
    description = description
) {

    constructor(description: String?) : this(
        message = null,
        description = description
    )
}