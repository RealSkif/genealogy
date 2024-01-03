package genealogy.web.settlement

import genealogy.domain.settlement.crud.*
import genealogy.domain.utils.command.CommandBus
import genealogy.domain.utils.query.QueryBus
import genealogy.web.settlement.SettlementMapper.toDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/settlements")
@Tag(name = "Населенные пункты")
class SettlementController(
    private val queryBus: QueryBus,
    private val commandBus: CommandBus
) {
    @Transactional()
    @PostMapping()
    @Operation(summary = "Сохранение населенного пункта")
    fun saveSettlement(
        @RequestBody settlement: SettlementDto
    ): Unit =
        commandBus.execute(
            command = SaveSettlementCommand(settlement)
        )

    @Transactional()
    @PostMapping("/batch")
    @Operation(summary = "Сохранение населенных пунктов")
    fun saveSettlements(
        @RequestBody settlements: Collection<SettlementDto>
    ): Unit =
        commandBus.execute(
            command = SaveSettlementsCommand(settlements)
        )

    @Transactional()
    @PatchMapping("/update")
    @Operation(summary = "Изменение населенного пункта")
    fun updateSettlement(
        @RequestBody settlement: SettlementDto,
    ): Unit =
        commandBus.execute(
            command = UpdateSettlementCommand(settlement)
        )

    @Transactional()
    @PatchMapping("/update/batch")
    @Operation(summary = "Изменение населенных пунктов")
    fun updateSettlements(
        @RequestBody settlements: Collection<SettlementDto>
    ): Unit =
        commandBus.execute(
            command = UpdateSettlementsCommand(settlements)
        )

    @Transactional()
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Удаление населенного пункта")
    fun deleteSettlement(
        @PathVariable id: UUID
    ): Unit =
        commandBus.execute(
            command = DeleteSettlementCommand(id)
        )

    @Transactional()
    @DeleteMapping("/delete/batch")
    @Operation(summary = "Удаление населенных пунктов")
    fun deleteSettlements(
        @RequestBody settlementIds: Collection<UUID>
    ): Unit =
        commandBus.execute(
            command = DeleteSettlementsCommand(settlementIds)
        )

    @Transactional(readOnly = true)
    @GetMapping()
    @Operation(summary = "")
    fun findAll(): Collection<SettlementDto> {
        return queryBus.execute(
            query = FindAllSettlementsQuery()
        ).toDto()
    }
}