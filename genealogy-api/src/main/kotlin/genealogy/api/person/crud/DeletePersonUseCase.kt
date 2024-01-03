package genealogy.api.person.crud

import genealogy.api.util.stereotype.UseCase
import genealogy.domain.person.PersonRepository
import java.util.UUID

/** Удаление людей */

@UseCase
class DeletePersonUseCase(
    private val personRepository: PersonRepository
) {
    /** Удаление человека
     *
     * @param personId Удаляемый человек
     */
    fun execute(personId: UUID) {
        personRepository.delete(personId)
    }

    /** Удаление людей
     *
     * @param personIds Удаляемые люди
     */
    fun execute(personIds: Collection<UUID>) {
        personRepository.deleteBatch(personIds)
    }

}
