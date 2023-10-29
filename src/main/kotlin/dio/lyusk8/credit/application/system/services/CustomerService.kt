package dio.lyusk8.credit.application.system.services

import dio.lyusk8.credit.application.system.entities.Customer
import dio.lyusk8.credit.application.system.repositories.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(val repository: CustomerRepository): ICustomerService {
    override fun save(customer: Customer): Customer = this.repository.save(customer)

    override fun findById(id: Long): Customer = this.repository.findById(id).orElseThrow{
        throw RuntimeException("Id $id not found")
    }
    override fun delete(id: Long): Unit {return this.repository.deleteById(id)}

    fun findAll(): List<Customer>? = repository.findAll()
}