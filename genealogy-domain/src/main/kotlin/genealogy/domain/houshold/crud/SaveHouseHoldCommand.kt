package genealogy.domain.houshold.crud

import genealogy.domain.houshold.HouseHold
import genealogy.domain.utils.command.Command

/** Команда сохранения двора */
class SaveHouseHoldCommand(
    val houseHold: HouseHold
): Command<Unit>