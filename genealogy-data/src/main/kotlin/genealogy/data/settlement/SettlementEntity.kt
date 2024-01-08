package genealogy.data.settlement

import genealogy.data.document.DocumentEntity
import genealogy.data.person.PersonEntity
import genealogy.domain.settlement.Settlement
import java.util.*
import jakarta.persistence.*

/** Поселение */
@Entity
@Table(schema = "genealogy", name = "settlement")
class SettlementEntity(

    /** Идентификатор поселения */
    @Id
    @Column(name = "settlementId")
    override val settlementId: UUID = UUID.randomUUID(),

    /** Наименование поселения */
    @Column(name = "settlementName")
    override val settlementName: String,

    /** Документы, в которых упоминается поселение */
    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST], )
    @JoinTable(
        name = "document_settlement",
        joinColumns = [JoinColumn(name = "settlementId")],
        inverseJoinColumns = [JoinColumn(name = "documentId")]
    )
    override var documents: MutableCollection<DocumentEntity> = mutableListOf(),

    /** Люди, проживавшие в поселении */
    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST], mappedBy = "settlements")
    override var persons: MutableCollection<PersonEntity>? = mutableListOf()
) : Settlement