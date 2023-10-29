package dio.lyusk8.credit.application.system.services

import dio.lyusk8.credit.application.system.entities.Credit
import java.util.UUID

interface ICreditService {

    fun save(credit: Credit): Credit

    fun findByCustomer(customerId: Long): List<Credit>

    fun findByCreditCode(customerId: Long, creditCode: UUID): Credit
}