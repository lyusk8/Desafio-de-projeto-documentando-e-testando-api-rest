package dio.lyusk8.credit.application.system.controller.dto

import dio.lyusk8.credit.application.system.entities.Customer
import java.math.BigDecimal

data class CustomerViw(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val zipCode: String,
    val street: String
){
    constructor(customer: Customer): this (
        firstName = customer.firstName,
        lastName = customer.lasstName,
        cpf = customer.cpf,
        income = customer.income,
        email = customer.email,
        zipCode = customer.address.zipCode,
        street = customer.address.street
    )
}