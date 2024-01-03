package genealogy.api.document.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.document.Document
import genealogy.domain.document.crud.FindAllDocumentsQuery
import genealogy.domain.utils.query.QueryHandler

@Handler
class FindAllDocumentsQueryHandler(
    private val findAllDocumentsUseCase: FindAllDocumentsUseCase
): QueryHandler<FindAllDocumentsQuery,Collection<Document>> {
    override fun handle(query: FindAllDocumentsQuery): Collection<Document> =
        findAllDocumentsUseCase.execute()
}