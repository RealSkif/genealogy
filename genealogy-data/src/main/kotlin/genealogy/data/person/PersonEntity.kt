package genealogy.data.person

import genealogy.data.document.DocumentEntity
import genealogy.data.household.HouseHoldEntity
import genealogy.data.settlement.SettlementEntity
import genealogy.domain.person.Person
import genealogy.domain.person.PersonAdditionalInfoEnum
import genealogy.domain.person.SocialStatusEnum
import jakarta.persistence.*
import java.util.*

/** Человек */
@Entity
@Table(schema = "genealogy", name = "person")
class PersonEntity(

    /** Идентификатор человека */
    @Id
    @Column(name = "personId")
    override val personId: UUID = UUID.randomUUID(),

    /** Имя человека */
    @Column(name = "FirstName")
    override val firstName: String,

    /** Фамилия человека */
    @Column(name = "SecondName")
    override val secondName: String,

    /** Отчество человека */
    @Column(name = "MiddleName")
    override val middleName: String,

    /** Возраст */
    @Column(name = "BirthYear")
    override val birthYear: Int,

    /** Идентификатор матери человека */
    @Column(name = "MotherId")
    override val motherId: UUID?,

    /** Идентификатор отца человека */
    @Column(name = "FatherId")
    override val fatherId: UUID?,

    /** Социальный статус человека */
    @Column(name = "SocialStatus")
    @Enumerated(EnumType.STRING)
    override val socialStatus: SocialStatusEnum,

    /** Дополнительная информация */
    @Column(name = "AdditionalInfo")
    @Enumerated(EnumType.STRING)
    override val additionalInfo: PersonAdditionalInfoEnum? = null,

    /** Документы, в которых упоминается человек */
    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinTable(
        name = "document_person",
        joinColumns = [JoinColumn(name = "personId")],
        inverseJoinColumns = [JoinColumn(name = "documentId")]
    )

    override var documents: MutableList<DocumentEntity>,

    /** Поселения, в которых проживал человек */
    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinTable(
        name = "settlement_person",
        joinColumns = [JoinColumn(name = "personId")],
        inverseJoinColumns = [JoinColumn(name = "settlementId")]
    )

    override var settlements: MutableList<SettlementEntity>,

    /** Дворы, в которых проживал человек */
    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinTable(
        name = "household_person",
        joinColumns = [JoinColumn(name = "personId")],
        inverseJoinColumns = [JoinColumn(name = "houseHoldId")]
    )
    override var houseHolds: MutableList<HouseHoldEntity>
) : Person
