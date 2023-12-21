package genealogy.web.household

import genealogy.domain.houshold.HouseHold
import genealogy.web.person.PersonDto
import genealogy.web.village.VillageDto
import java.util.*

class HouseHoldDto(
    override val id: UUID,
    override val houseHoldNumber: Int,
    override val village: VillageDto,
    override val persons: Collection<PersonDto>
) : HouseHold {


}