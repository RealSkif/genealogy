package genealogy.data.household

import com.querydsl.jpa.impl.JPAQuery
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class HouseHoldJpaRepositoryExtensionImpl(
//    private val entityManager: EntityManager
) : HouseHoldJpaRepositoryExtension {


//    override fun findAll(): Collection<HouseHoldEntity> =
//        JPAQuery<HouseHoldEntity>(entityManager)
//            .select(houseHoldEntity)
//            .from(houseHoldEntity)
//            .join(personEntity).on(personEntity.houseHoldId.eq(houseHoldEntity.houseHoldEntityId)).fetchJoin()
//            .orderBy(houseHoldEntity.houseHoldNumber.sort.asc())
//            .fetch()
}