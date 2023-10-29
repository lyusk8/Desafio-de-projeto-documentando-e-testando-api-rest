package dio.lyusk8.credit.application.system.exceptions

import java.time.LocalDate

data class ExceptionsDetails(
    val title: String,
    val timestamp: LocalDate,
    val status: Int,
    val exception: String,
    val details: MutableMap<String, String?>
)
