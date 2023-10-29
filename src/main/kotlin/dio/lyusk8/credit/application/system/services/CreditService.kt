package dio.lyusk8.credit.application.system.services

import dio.lyusk8.credit.application.system.entities.Credit
import dio.lyusk8.credit.application.system.repositories.CreditRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditepository.save(credit)
    }

    override fun findByCustomer(customerId: Long): List<Credit> = this.creditepository.findAllByCustomerId(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit : Credit = (this.creditepository.findByCreditCod(creditCode)?:
        throw RuntimeException("Creditcode $creditCode not found"))
       return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contact admin")
    }
}