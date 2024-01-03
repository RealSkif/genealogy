package genealogy.domain.houshold.crud

import genealogy.domain.utils.command.Command
import java.util.UUID

/** Команда удаления дворов */
class DeleteHouseHoldsCommand(
    val houseHoldIds: Collection<UUID>
) : Command<Unit>