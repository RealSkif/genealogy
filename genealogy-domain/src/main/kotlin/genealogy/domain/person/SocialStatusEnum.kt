package genealogy.domain.person

import genealogy.domain.document.DocumentTypeEnum

/** Enum с социальными статусами человека */
enum class SocialStatusEnum(
    val status: String
) {
    CLERICAL("духовный и его домашние"),
    PEASANT("поселяне"),
    LONE("бобыли"),
    MILITARY("военные и их домашние"),
    FARMER("крестьяне");

    companion object {
        fun findByStatus(status: String): SocialStatusEnum? =
            SocialStatusEnum.entries.firstOrNull { it.status == status }
    }
}