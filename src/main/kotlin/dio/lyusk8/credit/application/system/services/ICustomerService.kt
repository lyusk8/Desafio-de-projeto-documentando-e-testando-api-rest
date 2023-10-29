package dio.lyusk8.credit.application.system.services

import dio.lyusk8.credit.application.system.entities.Customer

interface ICustomerService {

    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long)
}