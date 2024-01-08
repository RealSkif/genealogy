package genealogy.domain.exception

import org.springframework.http.HttpStatus

/**
 * Параметры при работе с исключениями
 */
object CustomExceptionProperties {

    /**
     * Стандартный http статус при возникновении исключения
     */
    val status: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR

    /**
     * Стандартный текст ошибки
     */
    const val DEFAULT_DESCRIPTION: String = "Произошла неизвестная ошибка"
}