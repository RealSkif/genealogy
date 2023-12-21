package genealogy.domain.person

interface PersonRepository {
    fun findAll(): Collection<Person>
}