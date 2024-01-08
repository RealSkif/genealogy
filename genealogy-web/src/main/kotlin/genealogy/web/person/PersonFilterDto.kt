package genealogy.web.person

import genealogy.domain.houshold.HouseHold
import genealogy.domain.person.Person
import genealogy.domain.person.PersonAdditionalInfoEnum
import genealogy.domain.person.PersonFilter
import genealogy.domain.person.SocialStatusEnum
import genealogy.web.settlement.SettlementDto
import genealogy.web.document.DocumentDto
import genealogy.web.household.HouseHoldDto
import io.swagger.v3.oas.annotations.media.Schema
import java.util.*

@Schema(name = "Фильтр поиска человека")
class PersonFilterDto(

    @Schema(name = "Имя человека")
    override val firstName: String?,

    @Schema(name = "Фамилия человека")
    override val secondName: String?,

    @Schema(name = "Отчество человека")
    override val middleName: String?,

    @Schema(name = "Возраст")
    override val birthYear: Int?,

    @Schema(name = "Идентификатор матери человека")
    override val motherId: UUID?,

    @Schema(name = "Идентификатор отца человека")
    override val fatherId: UUID?,

    @Schema(name = "Социальный статус человека")
    override val socialStatus: SocialStatusEnum?,

    @Schema(name = "Дополнительная информация")
    override val additionalInfo: PersonAdditionalInfoEnum?,

    @Schema(name = "Документы, в которых упоминается человек")
    override val documentIds: Collection<UUID>?,

    @Schema(name = "Поселения, в которых проживал человек")
    override val settlementIds: Collection<UUID>?,

    @Schema(name = "Дворы, в которых проживал человек")
    override val houseHoldIds: Collection<UUID>?,

    override val pageSize: Int? = 20,

    override val pageNumber: Int? = 1
) : PersonFilter