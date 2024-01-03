package genealogy.api.document.crud

import genealogy.api.util.stereotype.UseCase
import genealogy.domain.document.Document
import genealogy.domain.document.DocumentRepository

/** Обновление документа */
@UseCase
class UpdateDocumentUseCase(
    private val documentRepository: DocumentRepository
) {

    /** Обновление документа
     *
     * @param document Обновляемый документ
     */
    fun execute(document: Document) {
        documentRepository.save(document)
    }

    /** Обновление документов
     *
     * @param documents Обновляемые документы
     */
    fun execute(documents: Collection<Document>) {
        documentRepository.saveAll(documents)
    }
}