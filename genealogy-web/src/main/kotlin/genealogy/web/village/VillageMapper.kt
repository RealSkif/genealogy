package genealogy.web.village

import genealogy.web.person.PersonMapper.toDto
import genealogy.domain.village.Village
import genealogy.web.document.DocumentMapper.toDto
import genealogy.web.household.HouseHoldMapper.toDto

object VillageMapper {
    fun Village.toDto(): VillageDto =
        VillageDto(
            id = this.id,
            name = this.name,
            documents = this.documents.toDto(),
            houseHolds = this.houseHolds.toDto(),
            persons = this.persons.toDto()
        )
    fun Collection<Village>.toDto(): Collection<VillageDto> =
        map { it.toDto() }
}