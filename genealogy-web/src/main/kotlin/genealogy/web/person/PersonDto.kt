package genealogy.web.person

import genealogy.domain.houshold.HouseHold
import genealogy.domain.person.Person
import genealogy.domain.person.PersonAdditionalInfoEnum
import genealogy.domain.person.SocialStatusEnum
import genealogy.web.village.VillageDto
import genealogy.web.document.DocumentDto
import java.util.*

class PersonDto(
    override val id: UUID?,
    override val documents: Collection<DocumentDto>?,
    override val villages: Collection<VillageDto>?,
    override val firstName: String?,
    override val secondName: String?,
    override val middleName: String?,
    override val age: Int,
    override val motherId: UUID?,
    override val fatherId: UUID?,
    override val socialStatus: SocialStatusEnum?,
    override val additionalInfo: PersonAdditionalInfoEnum?,
    override val household: HouseHold
) : Person {
}