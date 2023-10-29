package dio.lyusk8.credit.application.system.controller

import dio.lyusk8.credit.application.system.controller.dto.CustomerDto
import dio.lyusk8.credit.application.system.controller.dto.CustomerUpdateDto
import dio.lyusk8.credit.application.system.controller.dto.CustomerViw
import dio.lyusk8.credit.application.system.entities.Customer
import dio.lyusk8.credit.application.system.services.CustomerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController(private val service: CustomerService) {

    @PostMapping
    fun salvar(@RequestBody @Valid customerDto: CustomerDto): ResponseEntity<String> {
        val customer = service.save(customerDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer $customer saved!")
    }

    @GetMapping("/{id}")
    fun findBtId(@PathVariable id: Long): ResponseEntity<CustomerViw> {
        val customer = this.service.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerViw(customer))
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<Customer>> {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.findAll())
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).body(this.service.delete(id))
    }

    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId") id: Long,
                       @RequestBody customerUpdateDto: CustomerUpdateDto
    ): ResponseEntity<CustomerViw>{
        val customer = this.service.findById(id)
        val customerUpdated: Customer = customerUpdateDto.toEntity(customer)
        val customerToUpdate: Customer = this.service.save(customerUpdated)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerViw(customerToUpdate))
    }
}


