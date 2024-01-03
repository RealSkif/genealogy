package genealogy.domain.document.crud

import genealogy.domain.document.Document
import genealogy.domain.utils.query.Query


class FindAllDocumentsQuery : Query<Collection<Document>> {
}