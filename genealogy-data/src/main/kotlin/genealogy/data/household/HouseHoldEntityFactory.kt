package genealogy.data.household

import genealogy.domain.houshold.HouseHold

object HouseHoldEntityFactory {
    fun HouseHold.toEntity(): HouseHoldEntity =
        HouseHoldEntity(
            houseHoldNumber = this.houseHoldNumber,
            settlementId = this.settlementId,
//            persons = mutableListOf()
        )

    fun Collection<HouseHold>.toEntity(): Collection<HouseHoldEntity> =
        this.map { it.toEntity() }
}