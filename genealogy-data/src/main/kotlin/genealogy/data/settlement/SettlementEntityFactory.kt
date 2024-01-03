package genealogy.data.settlement

import genealogy.data.document.DocumentEntityFactory.toEntity
import genealogy.domain.settlement.Settlement

object SettlementEntityFactory {
    fun Settlement.toEntity(): SettlementEntity =
        SettlementEntity(
            settlementName = this.settlementName,
//            documents = this.documents.toEntity()
        )

    fun Collection<Settlement>.toEntity(): Collection<SettlementEntity> =
        this.map { it.toEntity() }
}