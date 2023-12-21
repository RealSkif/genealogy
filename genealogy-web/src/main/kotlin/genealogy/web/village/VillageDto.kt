package genealogy.web.village

import genealogy.domain.village.Village
import genealogy.web.document.DocumentDto
import genealogy.web.household.HouseHoldDto
import genealogy.web.person.PersonDto
import java.util.*

class VillageDto(
    override val id: UUID,
    override val name: String,
    override val documents: Collection<DocumentDto>,
    override val houseHolds: Collection<HouseHoldDto>,
    override val persons: Collection<PersonDto>
) : Village {
}