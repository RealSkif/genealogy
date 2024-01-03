package genealogy.api.settlement.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.utils.query.QueryHandler
import genealogy.domain.settlement.crud.FindAllSettlementsQuery
import genealogy.domain.settlement.Settlement

@Handler
class FindAllSettlementsQueryHandler(
    private val findAllSettlementsUseCase: FindAllSettlementsUseCase
) : QueryHandler<FindAllSettlementsQuery, Collection<Settlement>> {
    override fun handle(query: FindAllSettlementsQuery): Collection<Settlement> =
        findAllSettlementsUseCase.execute()
}