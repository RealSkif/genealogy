package genealogy.data.document

import genealogy.domain.document.Document
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface DocumentJpaRepository : JpaRepository<DocumentEntity, UUID> {
    fun findByTitle(title: String): DocumentEntity?
    fun findByTitleIn(titles: Collection<String>): Collection<DocumentEntity>?
}