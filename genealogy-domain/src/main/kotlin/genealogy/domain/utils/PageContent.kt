package genealogy.domain.utils

/**
 * Интерфейс страницы данных
 */
interface PageContent<T> {
    val content: List<T>
    val last: Boolean
    val totalPages: Int
    val totalElements: Long
    val numberOfElements: Int
    val first: Boolean
    val size: Int
    val number: Int
}