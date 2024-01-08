package genealogy.data.document

import genealogy.domain.exception.EntityNotFoundException
import java.util.*

class DocumentNotFoundException(val id: UUID) :
    EntityNotFoundException("Тип с идентификатором $id не найден")