package dio.lyusk8.credit.application.system.controller.dto

import dio.lyusk8.credit.application.system.entities.Credit
import java.math.BigDecimal
import java.util.UUID

data class CreditViewList(
    val creditCod: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallment: Int
){
    constructor(credit: Credit) : this (
        creditCod = credit.creditCod,
        creditValue = credit.creditValue,
        numberOfInstallment = credit.numberOfInstalment
    )
}
