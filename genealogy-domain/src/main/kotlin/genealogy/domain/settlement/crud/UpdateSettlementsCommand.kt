package genealogy.domain.settlement.crud

import genealogy.domain.settlement.Settlement
import genealogy.domain.utils.command.Command

/** Команда обновления населенных пунктов */
class UpdateSettlementsCommand(
    val settlements: Collection<Settlement>
):Command<Unit> {
}