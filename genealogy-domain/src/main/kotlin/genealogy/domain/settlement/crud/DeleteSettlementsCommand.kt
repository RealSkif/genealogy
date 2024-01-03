package genealogy.domain.settlement.crud

import genealogy.domain.utils.command.Command
import java.util.UUID

/** Команда удаления населенных пунктов */
class DeleteSettlementsCommand(
    val settlementIds: Collection<UUID>
) : Command<Unit>