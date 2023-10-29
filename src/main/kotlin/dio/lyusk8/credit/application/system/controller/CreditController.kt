package dio.lyusk8.credit.application.system.controller

import dio.lyusk8.credit.application.system.controller.dto.CreditDto
import dio.lyusk8.credit.application.system.controller.dto.CreditView
import dio.lyusk8.credit.application.system.controller.dto.CreditViewList
import dio.lyusk8.credit.application.system.entities.Credit
import dio.lyusk8.credit.application.system.services.CreditService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditController(private val service: CreditService) {

    @GetMapping
    fun findAllByCustomerId(customerId: Long): ResponseEntity<List<CreditViewList>> {
        val creditList = this.service.findByCustomer(customerId).stream().map { credit -> CreditViewList(credit) }
            .collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(creditList)
    }

    @GetMapping("/{creditCode}")
    fun findAllByCreditCode(@RequestParam customerId: Long, @PathVariable creditCode: UUID): ResponseEntity<CreditView> {
        val  credit: Credit = this.service.findByCreditCode(customerId, creditCode)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }

    @PostMapping
    fun saveCredit(@RequestBody @Valid creditDto: CreditDto): ResponseEntity<String>{
        val credit: Credit = this.service.save(creditDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Credit ${credit.creditCod} - Customer ${credit.customer?.firstName} saved")
    }




}