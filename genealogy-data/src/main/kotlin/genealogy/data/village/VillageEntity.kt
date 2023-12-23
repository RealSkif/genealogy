package genealogy.data.village

import genealogy.data.document.DocumentEntity
import genealogy.data.household.HouseHoldEntity
import genealogy.data.person.PersonEntity
import genealogy.domain.document.Document
import genealogy.domain.houshold.HouseHold
import genealogy.domain.person.Person
import genealogy.domain.village.Village
import java.util.*
import jakarta.persistence.*


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
    override val documents: Collection<DocumentEntity>,


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "village")
    override val houseHolds: Collection<HouseHoldEntity> = mutableListOf(),

    @ManyToMany(mappedBy = "villages")
    override val persons: Collection<PersonEntity>
) : Village {
}