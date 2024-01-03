package genealogy.api.document.crud

import genealogy.api.util.stereotype.UseCase
import genealogy.domain.document.DocumentRepository
import java.util.UUID

/** Удаление документа */
@UseCase
class DeleteDocumentUseCase(
    private val documentRepository: DocumentRepository
) {

    /** Удаление документа
     *
     * @param documentId Идентификатор удаляемого документа
     */
    fun execute(documentId: UUID) {
        documentRepository.delete(documentId)
    }

    /** Удаление документов
     *
     * @param documentIds Идентификаторы удаляемых документов
     */
    fun execute(documentIds: Collection<UUID>) {
        documentRepository.deleteBatch(documentIds)
    }

}
