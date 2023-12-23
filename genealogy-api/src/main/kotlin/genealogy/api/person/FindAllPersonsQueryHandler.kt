package genealogy.api.person

import genealogy.api.util.stereotype.Handler
import genealogy.domain.person.FindAllPersonsQuery
import genealogy.domain.person.Person
import genealogy.domain.utils.query.QueryHandler

@Handler
class FindAllPersonsQueryHandler(
    private val findAllPersonsUseCase: FindAllPersonsUseCase
) : QueryHandler<FindAllPersonsQuery, Collection<Person>> {
    override fun handle(query: FindAllPersonsQuery): Collection<Person> =
        findAllPersonsUseCase.execute()
}