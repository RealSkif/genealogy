package genealogy.domain.settlement.crud

import genealogy.domain.settlement.Settlement
import genealogy.domain.utils.command.Command

/** Команда сохранения населенного пункта */
class SaveSettlementCommand(
    val settlement: Settlement
): Command<Unit> {
}