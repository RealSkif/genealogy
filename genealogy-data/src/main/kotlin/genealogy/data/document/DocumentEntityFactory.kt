package genealogy.data.document

import genealogy.domain.document.Document
import java.util.*

object DocumentEntityFactory {
    fun Document.toEntity(): DocumentEntity =
        DocumentEntity(
            documentId = this.documentId,
            title = this.title,
            documentType = this.documentType,
            documentDate = this.documentDate,
        )

    fun Collection<Document>.toEntity(): Collection<DocumentEntity> =
        this.map { it.toEntity() }
}