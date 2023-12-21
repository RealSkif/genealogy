package genealogy.data.document

import genealogy.domain.document.Document
import genealogy.domain.document.DocumentTypeEnum
import genealogy.domain.person.Person
import genealogy.domain.village.Village
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(schema = "Genealogy", name = "Person")
class DocumentEntity(
    @Id
    @Column(name = "DocumentId")
    override val id: UUID,

    @Column(name = "Title")
    override val title: String,

    @Column(name = "DocumentType")
    @Enumerated(EnumType.STRING)
    override val documentType: DocumentTypeEnum,
    override val year: LocalDate,

    @ManyToMany(mappedBy = "documents")
    override val villages: Collection<Village>,

    @ManyToMany(mappedBy = "documents")
    override val persons: Collection<Person>
) : Document {
}