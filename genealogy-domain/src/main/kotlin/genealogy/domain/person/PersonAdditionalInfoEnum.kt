package genealogy.domain.person

/** Enum с дополнительной информацией человека */
enum class PersonAdditionalInfoEnum(
    val description: String
) {
    WIDOW("Вдова/Вдовец");

    companion object {
        fun findByDescription(description: String): PersonAdditionalInfoEnum? =
            PersonAdditionalInfoEnum.entries.firstOrNull { it.description == description }
    }
}
