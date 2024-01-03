package genealogy.api.document.crud

import genealogy.api.util.stereotype.UseCase
import genealogy.domain.document.Document
import genealogy.domain.document.DocumentRepository

@UseCase
class FindAllDocumentsUseCase (
    private val documentRepository: DocumentRepository
){
fun execute(): Collection<Document> =
    documentRepository.findAll()
}