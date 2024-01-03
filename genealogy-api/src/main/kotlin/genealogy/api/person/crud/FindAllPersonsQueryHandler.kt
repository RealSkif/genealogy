package genealogy.api.person.crud

import genealogy.api.util.stereotype.Handler
import genealogy.domain.person.crud.FindAllPersonsQuery
import genealogy.domain.person.Person
import genealogy.domain.utils.query.QueryHandler

@Handler
class FindAllPersonsQueryHandler(
    private val findAllPersonsUseCase: FindAllPersonsUseCase
) : QueryHandler<FindAllPersonsQuery, Collection<Person>> {
    override fun handle(query: FindAllPersonsQuery): Collection<Person> =
        findAllPersonsUseCase.execute()
}