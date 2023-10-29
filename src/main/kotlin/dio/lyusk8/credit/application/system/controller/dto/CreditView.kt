package dio.lyusk8.credit.application.system.controller.dto

import dio.lyusk8.credit.application.system.entities.Credit
import dio.lyusk8.credit.application.system.enums.Status
import java.math.BigDecimal
import java.util.UUID

data class CreditView(
    val creditCod: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallment: Int,
    val status: Status,
    val emailCustomer: String?,
    val incomeCustomer: BigDecimal?
){
    constructor(credit: Credit): this (
        creditCod = credit.creditCod,
        creditValue = credit.creditValue,
        numberOfInstallment = credit.numberOfInstalment,
        status = credit.status,
        emailCustomer = credit.customer?.email,
        incomeCustomer = credit.customer?.income
    )
}
