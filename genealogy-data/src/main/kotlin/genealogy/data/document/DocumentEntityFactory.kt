package genealogy.data.document

import genealogy.domain.document.Document

object DocumentEntityFactory {
    fun Document.toEntity(): DocumentEntity =
        DocumentEntity(
            title = this.title,
            documentType = this.documentType,
            documentDate = this.documentDate,
        )

    fun Collection<Document>.toEntity(): Collection<DocumentEntity> =
        this.map { it.toEntity() }
}