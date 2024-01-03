package genealogy.data.household

import genealogy.domain.houshold.HouseHold
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface HouseHoldJpaRepository :
    JpaRepository<HouseHoldEntity, UUID>,
    HouseHoldJpaRepositoryExtension {

    //TODO: Временный метод, могут возникнуть коллизии с дворами из других документов
    fun findByHouseHoldNumber(houseHoldNumber: Int): HouseHoldEntity?
    fun findByHouseHoldNumberIn(houseHoldNumbers: Collection<Int>): Collection<HouseHoldEntity>?
}