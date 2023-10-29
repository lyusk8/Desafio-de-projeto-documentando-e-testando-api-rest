package dio.lyusk8.credit.application.system.controller.dto

import dio.lyusk8.credit.application.system.entities.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CustomerUpdateDto (
    @field:NotEmpty(message = "Invalid first-name") val firstName: String,
    @field:NotEmpty(message = "Invalid lasst-name")val lastName: String,
    @field:NotNull(message = "Invalid first-name")val income: BigDecimal,
    @field:NotEmpty(message = "Invalid zip-code")val zipCode: String,
    @field:NotEmpty(message = "Invalid street")val street: String
){
    fun toEntity(customer: Customer): Customer{
        customer.firstName = this.firstName
        customer.lasstName = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street
        return customer
    }
}