package genealogy.api.document.crud

import genealogy.api.util.stereotype.UseCase
import genealogy.domain.document.Document
import genealogy.domain.document.DocumentRepository
import java.util.*

@UseCase
class FindDocumentUseCase(
    private val documentRepository: DocumentRepository
) {
    fun execute(documentId: UUID): Document =
        documentRepository.findByIdOrThrow(documentId)
}