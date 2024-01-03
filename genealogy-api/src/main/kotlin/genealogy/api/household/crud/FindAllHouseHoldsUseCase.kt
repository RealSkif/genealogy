
package genealogy.api.household.crud

import genealogy.api.util.stereotype.UseCase
import genealogy.domain.houshold.HouseHold
import genealogy.domain.houshold.HouseHoldRepository
import genealogy.domain.person.Person
import genealogy.domain.person.PersonRepository

@UseCase
class FindAllHouseHoldsUseCase(
    private val householdRepository: HouseHoldRepository
) {

    fun execute(): Collection<HouseHold> {
      val x =   householdRepository.findAll()
return x
    }
}