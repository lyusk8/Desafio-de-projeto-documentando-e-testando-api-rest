package dio.lyusk8.credit.application.system.entities

import dio.lyusk8.credit.application.system.enums.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@Entity
data class Credit (

    @Column(nullable = false, unique = true) val creditCod : UUID = UUID.randomUUID(),
    @Column(nullable = false) val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) val dayFirstInstallment: LocalDate,
    @Column(nullable = false) val numberOfInstalment: Int = 0,
    @Enumerated val status: Status = Status.IN_PROGRESS,
    @ManyToOne var customer: Customer? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
    )
