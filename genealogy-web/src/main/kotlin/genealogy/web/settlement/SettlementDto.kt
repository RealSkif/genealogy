package genealogy.web.settlement

import genealogy.domain.settlement.Settlement
import genealogy.web.document.DocumentDto
import genealogy.web.person.PersonDto
import io.swagger.v3.oas.annotations.media.Schema
import java.util.*

@Schema(name = "Поселение")
class SettlementDto(

    @Schema(name = "Идентификатор поселения")
    override val settlementId: UUID? = null,

    @Schema(name = "Наименование поселения")
    override val settlementName: String,

    @Schema(name = "Документы, в которых упоминается поселение")
    override val documents: Collection<DocumentDto> = mutableListOf(),

    @Schema(name = "Люди, проживавшие в поселении")
    override val persons: Collection<PersonDto>? = mutableListOf()
) : Settlement