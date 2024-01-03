package genealogy.web.household

import genealogy.domain.houshold.HouseHold
import genealogy.web.person.PersonDto
import genealogy.web.settlement.SettlementDto
import io.swagger.v3.oas.annotations.media.Schema
import java.util.*

@Schema(name = "Двор")
class HouseHoldDto(

    @Schema(name = "Идентификатор двора")
    override val houseHoldId: UUID? = null,

    @Schema(name = "Номер двора")
    override val houseHoldNumber: Int,

    @Schema(name = "Поселение, к которому относится двор")
    override val settlementId: UUID,

    @Schema(name = "Люди, относящиеся к двору")
    override val persons: Collection<PersonDto> = mutableListOf(),
) : HouseHold