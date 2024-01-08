package genealogy.api.person

import genealogy.api.util.stereotype.Handler
import genealogy.domain.person.FindPersonsByFilterQuery
import genealogy.domain.person.Person
import genealogy.domain.utils.query.QueryHandler
import org.springframework.data.domain.Page

@Handler
class FindPersonsByFilterQueryHandler(
    private val findPersonsByFilterUseCase: FindPersonsByFilterUseCase
) : QueryHandler<FindPersonsByFilterQuery, Page<Person>> {
    override fun handle(query: FindPersonsByFilterQuery): Page<Person> =
        findPersonsByFilterUseCase.execute(query.personFilter)
}