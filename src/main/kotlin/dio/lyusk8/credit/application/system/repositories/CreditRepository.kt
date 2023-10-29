package dio.lyusk8.credit.application.system.repositories

import dio.lyusk8.credit.application.system.entities.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CreditRepository : JpaRepository<Credit, Long>{

    fun findByCreditCod(creditCod: UUID): Credit?

    @Query(value = "SELECT * FROM CREDIT WHERE CUSTOMER_ID = ?1", nativeQuery = true)
    fun findAllByCustomerId(customerId: Long): List<Credit>
}