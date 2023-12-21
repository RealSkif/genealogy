package genealogy.data.household

import genealogy.domain.houshold.HouseHold
import genealogy.domain.person.Person
import genealogy.domain.village.Village
import java.util.*
import javax.persistence.*

@Entity
@Table(schema = "Genealogy", name = "HouseHold")
class HouseHoldEntity(
    @Id
    @Column(name = "HouseHoldId")
    override val id: UUID,

    @Column(name = "HouseHoldNumber")
    override val houseHoldNumber: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
        schema = "Genealogy", name = "Village",
        joinColumns = [JoinColumn(name = "VillageId")],
        inverseJoinColumns = [JoinColumn(name = "HouseHoldId")]
    )
    override val village: Village,

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "PersonId", referencedColumnName = "HouseHoldId")
    override val persons: Collection<Person> = mutableListOf(),
) : HouseHold {
}