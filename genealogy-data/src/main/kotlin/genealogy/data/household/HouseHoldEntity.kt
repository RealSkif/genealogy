package genealogy.data.household

import genealogy.data.person.PersonEntity
import genealogy.domain.houshold.HouseHold
import java.util.*
import jakarta.persistence.*

/** Двор */
@Entity
@Table(schema = "genealogy", name = "HouseHold")
class HouseHoldEntity(

    /** Идентификатор двора */
    @Id
    @Column(name = "HouseHoldId")
    override val houseHoldId: UUID = UUID.randomUUID(),

    /** Номер двора */
    @Column(name = "HouseHoldNumber")
    override val houseHoldNumber: Int,

    /** Поселение, к которому относится двор */
    @Column(name = "settlementId")
    override var settlementId: UUID,

    /** Люди, относящиеся к двору */
    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST], mappedBy = "houseHolds")
    override var persons: MutableCollection<PersonEntity> = mutableListOf()

) : HouseHold