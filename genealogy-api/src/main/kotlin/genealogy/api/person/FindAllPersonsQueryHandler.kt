import genealogy.api.config.stereotype.Handler
import genealogy.domain.person.FindAllPersonsQuery
import genealogy.domain.person.Person

@Handler
class FindAllPersonsQueryHandler(
    private val findAllPersonsUseCase: FindAllPersonsUseCase
) : QueryHandler<FindAllPersonsQuery, Collection<Person>> {
    override fun handle(query: FindAllPersonsQuery): Collection<Person> =
        findAllPersonsUseCase.execute()
}