package genealogy.web.household

import genealogy.web.person.PersonMapper.toDto
import genealogy.domain.houshold.HouseHold
import genealogy.web.village.VillageMapper.toDto

object HouseHoldMapper {
    fun HouseHold.toDto() : HouseHoldDto =
        HouseHoldDto(
            id = this.id,
            houseHoldNumber = this.houseHoldNumber,
            village = this.village.toDto(),
            persons = this.persons.toDto()
        )
    fun Collection<HouseHold>.toDto(): Collection<HouseHoldDto> =
        map { it.toDto() }
}