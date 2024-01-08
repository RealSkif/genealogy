package genealogy.data.person

import com.querydsl.core.BooleanBuilder
import genealogy.data.person.QPersonEntity.personEntity
import genealogy.domain.person.PersonFilter
import org.springframework.stereotype.Component

@Component
class PersonFilterBuilder {
    fun build(params: PersonFilter): BooleanBuilder =
        BooleanBuilder()
            .apply {
                params.firstName?.let {
                    and(personEntity.firstName.eq(params.firstName))
                }
//                params.secondName?.let {
//                    and(personEntity.secondName.eq(it))
//                }
//                params.middleName?.let {
//                    and(personEntity.middleName.eq(it))
//                }
//                params.birthYear?.let {
//                    and(personEntity.birthYear.eq(it))
//                }
//                params.fatherId?.also {
//                    and(personEntity.fatherId.eq(it))
//                }
//                params.motherId?.also {
//                    and(personEntity.motherId.eq(it))
//                }
//                params.socialStatus?.also {
//                    and(personEntity.socialStatus.eq(it))
//                }
//                params.documents?.also {
//                    and(personEntity.documents.`in`(addressObjects.mapNotNull { it.id }))
//                }
//                params.settlements?.also {
//                    and(personEntity.settlements.`in`(addressObjects.mapNotNull { it.id }))
//                }
//                params.houseHolds?.also {
//                    and(personEntity.houseHolds.`in`(addressObjects.mapNotNull { it.id }))
//                }
            }

}