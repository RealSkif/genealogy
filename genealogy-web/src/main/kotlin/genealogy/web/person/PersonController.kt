package genealogy.web.person

import genealogy.domain.person.FindPersonsByFilterQuery
import genealogy.domain.person.Person
import genealogy.domain.person.crud.*
import genealogy.domain.settlement.crud.*
import genealogy.domain.utils.PageContent
import genealogy.domain.utils.PageContentImpl
import genealogy.domain.utils.command.CommandBus
import genealogy.domain.utils.query.QueryBus
import genealogy.web.person.PersonMapper.toDto
import genealogy.web.settlement.SettlementDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/persons")
@Tag(name = "Люди")
class PersonController(
    private val queryBus: QueryBus,
    private val commandBus: CommandBus
) {
    @Transactional()
    @PostMapping()
    @Operation(summary = "Сохранение человека")
    fun savePerson(
        @RequestBody person: PersonDto
    ): Unit =
        commandBus.execute(
            command = SavePersonCommand(person)
        )

    @Transactional()
    @PostMapping("/batch")
    @Operation(summary = "Сохранение людей")
    fun savePersons(
        @RequestBody persons: Collection<PersonDto>
    ): Unit =
        commandBus.execute(
            command = SavePersonsCommand(persons)
        )

    @Transactional()
    @PatchMapping("/update")
    @Operation(summary = "Изменение человека")
    fun updatePerson(
        @RequestBody person: PersonDto,
    ): Unit =
        commandBus.execute(
            command = UpdatePersonCommand(person)
        )

    @Transactional()
    @PatchMapping("/update/batch")
    @Operation(summary = "Изменение людей")
    fun updatePersons(
        @RequestBody persons: Collection<PersonDto>
    ): Unit =
        commandBus.execute(
            command = UpdatePersonsCommand(persons)
        )

    @Transactional()
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Удаление человека")
    fun deletePerson(
        @PathVariable id: UUID
    ): Unit =
        commandBus.execute(
            command = DeletePersonCommand(id)
        )

    @Transactional()
    @DeleteMapping("/delete/batch")
    @Operation(summary = "Удаление людей")
    fun deletePersons(
        @RequestBody personIds: Collection<UUID>
    ): Unit =
        commandBus.execute(
            command = DeletePersonsCommand(personIds)
        )


    @Transactional(readOnly = true)
    @GetMapping()
    @Operation(summary = "")
    fun findAll(): Collection<PersonDto> {
        val x = queryBus.execute(
            query = FindAllPersonsQuery()
        ).toDto()
        return x
    }

    @Transactional(readOnly = true)
    @GetMapping("/filter")
    @Operation(summary = "")
    fun findByFilter(
        @RequestBody personFilter: PersonFilterDto
    ): PageContent<PersonDto> {
        val x = queryBus.execute(
            query = FindPersonsByFilterQuery(personFilter)
        )
        return PageContentImpl(
            content = x.content.toDto().toList(),
            last = x.isLast,
            totalPages = x.totalPages,
            totalElements = x.totalElements,
            numberOfElements = x.numberOfElements,
            first = x.isFirst,
            size = x.size,
            number = x.number
        )
    }
}