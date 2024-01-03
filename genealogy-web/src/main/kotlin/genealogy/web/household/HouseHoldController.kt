package genealogy.web.household

import genealogy.domain.houshold.crud.*
import genealogy.domain.utils.command.CommandBus
import genealogy.domain.utils.query.QueryBus
import genealogy.web.household.HouseHoldMapper.toDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/households")
@Tag(name = "Дворы")
class HouseHoldController(
    private val queryBus: QueryBus,
    private val commandBus: CommandBus
) {
    @Transactional()
    @PostMapping()
    @Operation(summary = "Сохранение двора")
    fun saveHouseHold(
        @RequestBody household: HouseHoldDto
    ): Unit =
        commandBus.execute(
            command = SaveHouseHoldCommand(household)
        )

    @Transactional()
    @PostMapping("/batch")
    @Operation(summary = "Сохранение дворов")
    fun saveHouseHolds(
        @RequestBody households: Collection<HouseHoldDto>
    ): Unit =
        commandBus.execute(
            command = SaveHouseHoldsCommand(households)
        )

    @Transactional()
    @PatchMapping("/update")
    @Operation(summary = "Изменение двора")
    fun updateHouseHold(
        @RequestBody household: HouseHoldDto,
    ): Unit =
        commandBus.execute(
            command = UpdateHouseHoldCommand(household)
        )

    @Transactional()
    @PatchMapping("/update/batch")
    @Operation(summary = "Изменение дворов")
    fun updateHouseHolds(
        @RequestBody households: Collection<HouseHoldDto>
    ): Unit =
        commandBus.execute(
            command = UpdateHouseHoldsCommand(households)
        )

    @Transactional()
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Удаление двора")
    fun deleteHouseHold(
        @PathVariable id: UUID
    ): Unit =
        commandBus.execute(
            command = DeleteHouseHoldCommand(id)
        )

    @Transactional()
    @DeleteMapping("/delete/batch")
    @Operation(summary = "Удаление дворов")
    fun deleteHouseHolds(
        @RequestBody houseHoldIds: Collection<UUID>
    ): Unit =
        commandBus.execute(
            command = DeleteHouseHoldsCommand(houseHoldIds)
        )

    @Transactional(readOnly = true)
    @GetMapping()
    @Operation(summary = "")
    fun findAll(): Collection<HouseHoldDto> {
        val x = queryBus.execute(
            query = FindAllHouseHoldsQuery()
        )
        return x.toDto()
    }
}