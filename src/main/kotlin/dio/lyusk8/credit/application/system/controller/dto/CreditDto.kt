package dio.lyusk8.credit.application.system.controller.dto

import dio.lyusk8.credit.application.system.entities.Credit
import dio.lyusk8.credit.application.system.entities.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Invalid first-name")val creditValue: BigDecimal,
    @field:Future(message = "Invalid first-name")val dayFirstInstallment: LocalDate,
    @field:Max(value = 12) val numberOfInstallment: Int,
    @field:NotNull(message = "Invalid first-name")val customerId:Long
){
    fun toEntity(): Credit = Credit (
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstalment = this.numberOfInstallment,
        customer = Customer(id = this.customerId)
    )
}