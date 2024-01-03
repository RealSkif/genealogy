package genealogy.data.household

import genealogy.data.household.HouseHoldEntityFactory.toEntity
import genealogy.domain.houshold.HouseHold
import genealogy.domain.houshold.HouseHoldRepository
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.stereotype.Repository
import java.util.*

/** Репозиторий для работы с дворами */
@Repository
class HouseHoldRepositoryImpl(
    private val houseHoldJpaRepository: HouseHoldJpaRepository
) : HouseHoldRepository {
    override fun save(houseHold: HouseHold) {
        houseHoldJpaRepository.save(houseHold.toEntity())
    }

    override fun saveAll(houseHolds: Collection<HouseHold>) {
        houseHoldJpaRepository.saveAll(houseHolds.toEntity())
    }

    override fun delete(houseHoldId: UUID) {
        houseHoldJpaRepository.deleteById(houseHoldId)
    }

    override fun deleteBatch(houseHoldIds: Collection<UUID>) {
        houseHoldJpaRepository.deleteAllById(houseHoldIds)
    }

    override fun findByHouseHoldNumber(houseHoldNumber: Int): HouseHold? =
        houseHoldJpaRepository.findByHouseHoldNumber(houseHoldNumber)


    override fun findByHouseHoldNumber(houseHoldNumbers: Collection<Int>): Collection<HouseHold>? =
        houseHoldJpaRepository.findByHouseHoldNumberIn(houseHoldNumbers)


    @EntityGraph(attributePaths = ["persons"])
    override fun findAll(): Collection<HouseHold> =
        houseHoldJpaRepository.findAll()
}