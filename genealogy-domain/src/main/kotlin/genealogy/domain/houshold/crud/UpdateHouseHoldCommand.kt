package genealogy.domain.houshold.crud

import genealogy.domain.houshold.HouseHold
import genealogy.domain.utils.command.Command

/** Команда обновления двора */
class UpdateHouseHoldCommand(
    val houseHold: HouseHold
) : Command<Unit>