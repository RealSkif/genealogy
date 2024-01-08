package genealogy.web.document

import genealogy.domain.document.crud.*
import genealogy.domain.utils.command.CommandBus
import genealogy.domain.utils.query.QueryBus
import genealogy.web.document.DocumentMapper.toDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/documents")
@CrossOrigin(origins = ["http://localhost:3000"])
@Tag(name = "Документы")
class DocumentController(
    private val queryBus: QueryBus,
    private val commandBus: CommandBus
) {
    @Transactional()
    @PostMapping()
    @Operation(summary = "Сохранение документа")
    fun saveDocument(
        @RequestBody document: DocumentDto
    ): Unit =
        commandBus.execute(
            command = SaveDocumentCommand(document)
        )

    @Transactional()
    @PostMapping("/batch")
    @Operation(summary = "Сохранение документов")
    fun saveDocuments(
        @RequestBody documents: Collection<DocumentDto>
    ): Unit =
        commandBus.execute(
            command = SaveDocumentsCommand(documents)
        )

    @Transactional()
    @PatchMapping("/update")
    @Operation(summary = "Изменение документа")
    fun updateDocument(
        @RequestBody document: DocumentDto,
    ): Unit =
        commandBus.execute(
            command = UpdateDocumentCommand(document)
        )

    @Transactional()
    @PatchMapping("/update/batch")
    @Operation(summary = "Изменение документов")
    fun updateDocuments(
        @RequestBody documents: Collection<DocumentDto>
    ): Unit =
        commandBus.execute(
            command = UpdateDocumentsCommand(documents)
        )

    @Transactional()
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    @Operation(summary = "Удаление документа")
    fun deleteDocument(
        @PathVariable id: UUID
    ): Unit =
        commandBus.execute(
            command = DeleteDocumentCommand(id)
        )

    @Transactional()
    @DeleteMapping("/delete/batch")
    @Operation(summary = "Удаление документов")
    fun deleteDocuments(
        @RequestBody documentIds: Collection<UUID>
    ): Unit =
        commandBus.execute(
            command = DeleteDocumentsCommand(documentIds)
        )

    @Transactional(readOnly = true)
    @GetMapping()
    @Operation(summary = "")
    fun findAll(): Collection<DocumentDto> {
        val documents = queryBus.execute(
            query = FindAllDocumentsQuery()
        ).toDto()
        return documents
    }

    @Transactional(readOnly = true)
    @GetMapping("/{id}")
    @Operation(summary = "Поиск документа по идентификатору")
    fun findById(
        @PathVariable id: UUID
    ): DocumentDto = queryBus.execute(
        query = FindDocumentByIdQuery(id)
    ).toDto()

}