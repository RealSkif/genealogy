package genealogy.data.person

import genealogy.domain.person.Person
import genealogy.domain.person.PersonAdditionalInfoEnum
import genealogy.domain.person.SocialStatusEnum
import genealogy.domain.village.Village
import genealogy.domain.document.Document
import java.util.*
import javax.persistence.*

/**
 * Обращение
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

    @OneToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "MotherId", referencedColumnName = "PersonId")
    override val mother: Person,

    @OneToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "FatherId", referencedColumnName = "PersonId")
    override val father: Person,

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
    override val documents: Collection<Document>,

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinTable(
        name = "Village_Person",
        joinColumns = [JoinColumn(name = "PersonId")],
        inverseJoinColumns = [JoinColumn(name = "VillageId")]
    )
    override val villages: Collection<Village>
) : Person
