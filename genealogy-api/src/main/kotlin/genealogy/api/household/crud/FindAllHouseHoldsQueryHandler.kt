package genealogy.api.household.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.houshold.crud.FindAllHouseHoldsQuery
import genealogy.domain.houshold.HouseHold
import genealogy.domain.utils.query.QueryHandler


@Handler
class FindAllHouseHoldsQueryHandler(
    private val findAllHouseHoldsUseCase: FindAllHouseHoldsUseCase
) : QueryHandler<FindAllHouseHoldsQuery, Collection<HouseHold>> {
    override fun handle(query: FindAllHouseHoldsQuery): Collection<HouseHold> =
        findAllHouseHoldsUseCase.execute()
}