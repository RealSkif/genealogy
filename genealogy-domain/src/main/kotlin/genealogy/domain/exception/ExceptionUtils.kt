package genealogy.domain.exception

import org.hibernate.exception.GenericJDBCException
import org.springframework.dao.UncategorizedDataAccessException
import genealogy.domain.exception.StringPool.BLANK
import genealogy.domain.exception.StringPool.RETURN_NEW_LINE

object ExceptionUtils {
    /**
     * Вывести сообщение и стек вызова исключения
     */
    fun Exception.stackTraceAndMessage(isStart: Boolean = true) =
        when {
            isStart && this is DomainException -> stackTraceDescriptionMessage()
            else -> ((message ?: BLANK) + RETURN_NEW_LINE + stackTraceToString())
        }

    /**
     * Вывести сообщение
     */
    fun Exception.stackMessage() =
        (message ?: BLANK)

    /**
     * Вывести сообщение
     */
    fun Exception.stackMessage2(): String =
        when (this) {
            is DomainException -> description
            is UncategorizedDataAccessException -> if (cause is GenericJDBCException) {
                val sqlException = (cause as GenericJDBCException).sqlException
                when {
                    (sqlException.errorCode >= 20000) -> {
                        val messages = sqlException.message?.split("ORA-[0-9]{5}:".toRegex())
                        messages?.elementAtOrNull(1)?.let { message ->
                            return message.trim().let {
                                "0x([0-9a-fA-F]{4}) - ".toRegex().replace(it, "")
                            }
                        }
                    }
                    else -> sqlException.message
                } ?: message
            } else message
            else -> message
        } ?: BLANK

}