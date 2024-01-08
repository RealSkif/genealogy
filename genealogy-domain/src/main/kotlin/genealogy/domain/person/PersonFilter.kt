package genealogy.domain.person

import java.util.*

interface PersonFilter {

    val firstName: String?

    val secondName: String?

    val middleName: String?

    val birthYear: Int?

    val motherId: UUID?

    val fatherId: UUID?

    val socialStatus: SocialStatusEnum?

    val additionalInfo: PersonAdditionalInfoEnum?

    val documentIds: Collection<UUID>?

    val settlementIds: Collection<UUID>?

    val houseHoldIds: Collection<UUID>?

    val pageSize: Int?

    val pageNumber: Int?
}