package genealogy.domain.settlement.crud

import genealogy.domain.utils.command.Command
import java.util.UUID

/** Команда удаления населенного пункта */
class DeleteSettlementCommand(
    val settlementId: UUID
) : Command<Unit>