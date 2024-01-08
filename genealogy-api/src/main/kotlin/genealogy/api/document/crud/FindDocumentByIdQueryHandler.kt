package genealogy.api.document.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.document.Document
import genealogy.domain.document.crud.FindDocumentByIdQuery
import genealogy.domain.utils.query.QueryHandler

@Handler
class FindDocumentByIdQueryHandler(
    val findDocumentUseCase: FindDocumentUseCase
)
    : QueryHandler<FindDocumentByIdQuery, Document> {
    override fun handle(query: FindDocumentByIdQuery): Document =
        findDocumentUseCase.execute(query.documentId)
}