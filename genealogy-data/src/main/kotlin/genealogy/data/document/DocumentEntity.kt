package genealogy.data.document

import genealogy.data.person.PersonEntity
import genealogy.data.settlement.SettlementEntity
import genealogy.domain.document.Document
import genealogy.domain.document.DocumentTypeEnum
import jakarta.persistence.*
import java.time.LocalDate
import java.util.*

/** Документ */
@Entity
@Table(schema = "genealogy", name = "Document")
class DocumentEntity(

    /** Идентификатор документа */
    @Id
    @Column(name = "DocumentId")
    override val documentId: UUID? = UUID.randomUUID(),

    /** Наименование документа */
    @Column(name = "Title")
    override val title: String,

    /** Тип документа */
    @Column(name = "DocumentType")
    @Enumerated(EnumType.STRING)
    override val documentType: DocumentTypeEnum,

    /** Дата документа */
    @Column(name = "Year")
    override val documentDate: LocalDate,

    /** Поселения, упоминаемые в документе */
    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST], mappedBy = "documents")
    override var settlements: MutableList<SettlementEntity>? = mutableListOf(),

    /** Люди, упоминаемые в документе */
    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST], mappedBy = "documents")
    override var persons: MutableList<PersonEntity>? = mutableListOf()
) : Document