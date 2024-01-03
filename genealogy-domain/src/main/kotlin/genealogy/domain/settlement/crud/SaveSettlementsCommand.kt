package genealogy.domain.settlement.crud

import genealogy.domain.settlement.Settlement
import genealogy.domain.utils.command.Command

/** Команда сохранения населенных пунктов */
class SaveSettlementsCommand(
    val settlements: Collection<Settlement>
): Command<Unit>