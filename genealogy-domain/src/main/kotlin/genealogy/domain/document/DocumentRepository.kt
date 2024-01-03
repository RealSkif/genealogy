package genealogy.domain.document

import java.util.UUID

/** Интерфейс репозитория для работы с документами */
interface DocumentRepository {
    fun save(document: Document)
    fun saveAll(documents: Collection<Document>)
    fun delete(documentId: UUID)
    fun deleteBatch(documentIds: Collection<UUID>)
    fun findByTitle(title: String): Document?
    fun findByTitle(titles: Collection<String>): Collection<Document>?
    fun findAll(): Collection<Document>
}