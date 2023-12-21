package genealogy.data.village

import genealogy.domain.document.Document
import genealogy.domain.houshold.HouseHold
import genealogy.domain.person.Person
import genealogy.domain.village.Village
import java.util.*
import javax.persistence.*


@Entity
@Table(schema = "Genealogy", name = "Village")
class VillageEntity(

    @Id
    @Column(name = "VillageId")
    override val id: UUID,

    @Column(name = "VillageName")
    override val name: String,

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinTable(
        name = "Document_Village",
        joinColumns = [JoinColumn(name = "VillageId")],
        inverseJoinColumns = [JoinColumn(name = "DocumentId")]
    )
    override val documents: Collection<Document>,

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "VillageId", referencedColumnName = "HouseHold")
    override val houseHolds: Collection<HouseHold>,

    @ManyToMany(mappedBy = "villages")
    override val persons: Collection<Person>
) : Village {
}