package genealogy.web.person

import genealogy.domain.houshold.HouseHold
import genealogy.domain.person.Person
import genealogy.domain.person.PersonAdditionalInfoEnum
import genealogy.domain.person.SocialStatusEnum
import genealogy.web.settlement.SettlementDto
import genealogy.web.document.DocumentDto
import genealogy.web.household.HouseHoldDto
import io.swagger.v3.oas.annotations.media.Schema
import java.util.*

@Schema(name = "Человек")
class PersonDto(

    @Schema(name = "Идентификатор человека")
    override val personId: UUID?,

    @Schema(name = "Имя человека")
    override val firstName: String,

    @Schema(name = "Фамилия человека")
    override val secondName: String,

    @Schema(name = "Отчество человека")
    override val middleName: String,

    @Schema(name = "Возраст")
    override val birthYear: Int,

    @Schema(name = "Идентификатор матери человека")
    override val motherId: UUID?,

    @Schema(name = "Идентификатор отца человека")
    override val fatherId: UUID?,

    @Schema(name = "Социальный статус человека")
    override val socialStatus: SocialStatusEnum,

    @Schema(name = "Дополнительная информация")
    override val additionalInfo: PersonAdditionalInfoEnum?,

    @Schema(name = "Документы, в которых упоминается человек")
    override val documents: Collection<DocumentDto>,

    @Schema(name = "Поселения, в которых проживал человек")
    override val settlements: Collection<SettlementDto>,

    @Schema(name = "Дворы, в которых проживал человек")
    override val houseHolds: Collection<HouseHoldDto>
) : Person