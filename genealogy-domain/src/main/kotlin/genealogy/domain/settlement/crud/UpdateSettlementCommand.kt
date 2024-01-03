package genealogy.domain.settlement.crud

import genealogy.domain.settlement.Settlement
import genealogy.domain.utils.command.Command

/** Команда обновления населенного пункта */
class UpdateSettlementCommand(
    val settlement: Settlement
): Command<Unit>