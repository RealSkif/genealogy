package genealogy.data.person

import genealogy.data.document.DocumentEntity
import genealogy.data.household.HouseHoldEntity
import genealogy.data.village.VillageEntity
import genealogy.domain.houshold.HouseHold
import genealogy.domain.person.Person
import genealogy.domain.person.PersonAdditionalInfoEnum
import genealogy.domain.person.SocialStatusEnum
import java.util.*
import jakarta.persistence.*

/**
 * Человек
 */
@Entity
@Table(schema = "Genealogy", name = "Person")
//@DynamicUpdate
class PersonEntity(
    @Id
    @Column(name = "PersonId")
    override val id: UUID = UUID.randomUUID(),

    @Column(name = "FirstName")
    override val firstName: String,

    @Column(name = "SecondName")
    override val secondName: String,

    @Column(name = "MiddleName")
    override val middleName: String,

    @Column(name = "Age")
    override val age: Int,

    @Column(name = "MotherId")
//    @OneToOne(cascade = [CascadeType.PERSIST])
//    @JoinColumn(name = "MotherId", referencedColumnName = "PersonId")
    override val motherId: UUID,

    @Column(name = "FatherId")
//    @OneToOne(cascade = [CascadeType.PERSIST])
//    @JoinColumn(name = "FatherId", referencedColumnName = "PersonId")
    override val fatherId: UUID,

    @Column(name = "SocialStatus")
    @Enumerated(EnumType.STRING)
    override val socialStatus: SocialStatusEnum,

    @Column(name = "AdditionalInfo")
    @Enumerated(EnumType.STRING)
    override val additionalInfo: PersonAdditionalInfoEnum,

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinTable(
        name = "Document_Person",
        joinColumns = [JoinColumn(name = "PersonId")],
        inverseJoinColumns = [JoinColumn(name = "DocumentId")]
    )
    override val documents: Collection<DocumentEntity>,

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinTable(
        name = "Village_Person",
        joinColumns = [JoinColumn(name = "PersonId")],
        inverseJoinColumns = [JoinColumn(name = "VillageId")]
    )
    override val villages: Collection<VillageEntity>,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HouseHoldId", referencedColumnName = "HouseHoldId")
    override val household: HouseHoldEntity
) : Person
