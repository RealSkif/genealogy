package genealogy.domain.document.crud

import genealogy.domain.document.Document
import genealogy.domain.utils.query.Query
import java.util.UUID

class FindDocumentByIdQuery(
    val documentId: UUID
) : Query<Document>