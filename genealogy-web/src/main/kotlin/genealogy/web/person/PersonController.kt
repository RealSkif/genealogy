package genealogy.web.person

import QueryBus
import genealogy.web.person.PersonMapper.toDto
import genealogy.domain.person.FindAllPersonsQuery
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
@Tag(name = "Обращения")
class PersonController(
    private val queryBus: QueryBus
) {

    @Transactional(readOnly = true)
    @GetMapping()
    @Operation(summary = "")
    fun findAll(): Collection<PersonDto> =
        queryBus.execute(
            query = FindAllPersonsQuery()
        ).toDto()
}