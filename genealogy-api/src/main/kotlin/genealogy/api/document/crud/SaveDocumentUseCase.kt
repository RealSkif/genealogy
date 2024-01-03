package genealogy.api.document.crud

import genealogy.api.util.stereotype.UseCase
import genealogy.domain.document.Document
import genealogy.domain.document.DocumentRepository

/** Сохранение документов */
@UseCase
class SaveDocumentUseCase(
    private val documentRepository: DocumentRepository
) {
    /** Сохранение документа
     *
     * @param document Документ для сохранения
     */
    fun execute(document: Document) {
        val existingDocument: Document? = documentRepository.findByTitle(document.title)
        if (existingDocument == null)
            documentRepository.save(document)
    }

    /** Сохранение документов
     *
     * @param documents Документы для сохранения
     */
    fun execute(documents: Collection<Document>) {
        var existingDocumentsTitles: Collection<String> = listOf()
        val existingDocuments = documentRepository.findByTitle(documents.map { it.title })
        if (existingDocuments != null)
            existingDocumentsTitles = existingDocuments.map { it.title }
        val documentsToSave = documents.filter { !existingDocumentsTitles.contains(it.title) }
        documentRepository.saveAll(documentsToSave)
    }
}