package genealogy.data.person

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PersonJpaRepository : JpaRepository<PersonEntity, UUID> {

    //TODO: Временный метод, пока не найдется более точный способ идентифицировать нового человека
    fun findByFirstNameAndSecondNameAndMiddleName(
        firstName: String,
        secondName: String,
        middleName: String
    ): PersonEntity?
}