
package genealogy.api.settlement.crud

import genealogy.api.util.stereotype.UseCase
import genealogy.domain.settlement.Settlement
import genealogy.domain.settlement.SettlementRepository

@UseCase
class FindAllSettlementsUseCase(
    private val settlementRepository: SettlementRepository
) {

    fun execute(): Collection<Settlement> {
        val x = settlementRepository.findAll()
        return x
}
}