package genealogy.domain.document

/** Enum с перечислением типов документов */
enum class DocumentTypeEnum(
    val type: String
) {
    ConfessionList("Исповедная роспись"),
    MetricBook("Метрическая книга"),
    Revision("Ревизская сказка");
    companion object {
        fun findByTypes(type: String): DocumentTypeEnum? =
            entries.firstOrNull { it.type == type }
    }
}