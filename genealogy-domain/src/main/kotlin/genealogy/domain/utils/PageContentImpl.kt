package genealogy.domain.utils

/**
 * Реализация интерфейса страницы данных
 */
open class PageContentImpl<T>(
    override val content: List<T>,
    override val last: Boolean,
    override val totalPages: Int,
    override val totalElements: Long,
    override val numberOfElements: Int,
    override val first: Boolean,
    override val size: Int,
    override val number: Int
): PageContent<T> {
    constructor(content: List<T>, pageContent: PageContent<*>) : this (
        content = content,
        last = pageContent.last,
        totalPages = pageContent.totalPages,
        totalElements = pageContent.totalElements,
        numberOfElements = pageContent.numberOfElements,
        first = pageContent.first,
        size = pageContent.size,
        number = pageContent.number
    )
}