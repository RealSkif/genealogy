package genealogy.domain.houshold.crud

import genealogy.domain.houshold.HouseHold
import genealogy.domain.utils.command.Command

/** Команда обновления дворов */
class UpdateHouseHoldsCommand(
    val houseHolds: Collection<HouseHold>
):Command<Unit>