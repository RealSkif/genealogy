package genealogy.domain.person

import genealogy.domain.utils.query.Query
import org.springframework.data.domain.Page

class FindPersonsByFilterQuery(
    val personFilter: PersonFilter
) : Query <Page<Person>>