package genealogy.domain.houshold.crud

import genealogy.domain.houshold.HouseHold
import genealogy.domain.utils.command.Command

/** Команда сохранения дворов */
class SaveHouseHoldsCommand(
    val houseHolds: Collection<HouseHold>
): Command<Unit>