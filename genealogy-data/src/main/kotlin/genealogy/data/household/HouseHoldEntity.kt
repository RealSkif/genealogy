package genealogy.data.household

import genealogy.data.person.PersonEntity
import genealogy.data.village.VillageEntity
import genealogy.domain.houshold.HouseHold
import genealogy.domain.person.Person
import genealogy.domain.village.Village
import java.util.*
import jakarta.persistence.*

@Entity
@Table(schema = "Genealogy", name = "HouseHold")
class HouseHoldEntity(
    @Id
    @Column(name = "HouseHoldId")
    override val id: UUID,

    @Column(name = "HouseHoldNumber")
    override val houseHoldNumber: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VillageId", referencedColumnName = "VillageId")
    override val village: VillageEntity,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "household")
    override val persons: Collection<PersonEntity> = mutableListOf(),
) : HouseHold {
}