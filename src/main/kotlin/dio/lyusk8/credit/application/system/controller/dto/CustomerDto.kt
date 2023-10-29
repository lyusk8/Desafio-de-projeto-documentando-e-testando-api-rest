package dio.lyusk8.credit.application.system.controller.dto

import dio.lyusk8.credit.application.system.entities.Address
import dio.lyusk8.credit.application.system.entities.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "Invalid name") val firstName: String,
    @field:NotEmpty(message = "Invalid last name") val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    @field:Email(message = "Invalid email") val email: String,
    @field:NotEmpty(message = "Invalid password") val password: String,
    @field:NotEmpty(message = "Invalid zip-cod") val zipCod: String,
    @field:NotEmpty(message = "Invalid street") val street: String
){
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lasstName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCod,
            street = this.street

        )

    )
}