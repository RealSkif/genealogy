package genealogy.web.document

import genealogy.domain.document.Document
import genealogy.domain.document.DocumentTypeEnum
import genealogy.web.person.PersonDto
import genealogy.web.settlement.SettlementDto
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate
import java.util.*

@Schema(name = "Документ")
class DocumentDto(

    @Schema(name = "Идентификатор документа")
    override val documentId: UUID? = null,

    @Schema(name = "Наименование документа")
    override val title: String,

    @Schema(name = "Тип документа")
    override val documentType: DocumentTypeEnum,

    @Schema(name = "Дата документа")
    override val documentDate: LocalDate,

    @Schema(name = "Поселения, упоминаемые в документе")
    override val settlements: Collection<SettlementDto>? = mutableListOf(),

    @Schema(name = "Люди, упоминаемые в документе")
    override val persons: Collection<PersonDto>? = mutableListOf()
) : Document