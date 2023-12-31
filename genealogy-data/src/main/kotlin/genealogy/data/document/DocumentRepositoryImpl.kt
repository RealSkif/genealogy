package genealogy.data.document

import genealogy.data.document.DocumentEntityFactory.toEntity
import genealogy.domain.document.Document
import genealogy.domain.document.DocumentRepository
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.stereotype.Repository
import java.util.*

/** Репозиторий для работы с документами */
@Repository
class DocumentRepositoryImpl(
    private val documentJpaRepository: DocumentJpaRepository
) : DocumentRepository {
    override fun save(document: Document) {
        documentJpaRepository.save(document.toEntity())
    }

    override fun saveAll(documents: Collection<Document>) {
        documentJpaRepository.saveAll(documents.toEntity())
    }

    override fun delete(documentId: UUID) {
        documentJpaRepository.deleteById(documentId)
    }

    override fun deleteBatch(documentIds: Collection<UUID>) {
        documentJpaRepository.deleteAllById(documentIds)
    }

    override fun findByTitle(title: String): Document? =
        documentJpaRepository.findByTitle(title)

    override fun findByTitle(titles: Collection<String>): Collection<Document>? =
        documentJpaRepository.findByTitleIn(titles)


    override fun findAll(): Collection<Document> {
        val x = documentJpaRepository.findAll()
        return x}




    /**
     * Получение документа по идентификатору.
     * Выбрасывает исключение, если документ не найден
     *
     * @param documentId Идентификатор документа
     * @return Тип обращения
     */
    @EntityGraph(attributePaths = [
        "settlements", "persons"])
    override fun findByIdOrThrow(documentId: UUID): Document =
        documentJpaRepository.findById(documentId).orElseThrow {
            DocumentNotFoundException(documentId)
        }

}