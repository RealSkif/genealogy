package genealogy.web.person

import genealogy.domain.person.FindAllPersonsQuery
import genealogy.domain.utils.command.CommandBus
import genealogy.domain.utils.query.QueryBus
import genealogy.web.person.PersonMapper.toDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
@Tag(name = "Люди")
class PersonController(
    private val queryBus: QueryBus,
    private val commandBus: CommandBus
) {

    @Transactional(readOnly = true)
    @GetMapping()
    @Operation(summary = "")
    fun findAll(): Collection<PersonDto> {
//        commandBus.execute(
//            command = FindAllPersonsCommand()
//        )
        return queryBus.execute(
            query = FindAllPersonsQuery()
        ).toDto()
    }
}