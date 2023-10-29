package dio.lyusk8.credit.application.system.exceptions

import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDate

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handlerValidException(ex: MethodArgumentNotValidException): ResponseEntity<ExceptionsDetails>{
        val erros: MutableMap<String, String?> = HashMap()
        ex.bindingResult.allErrors.stream().forEach {
            erro: ObjectError -> val fieldName: String = (erro as
                    FieldError).field
            val messageError: String? = erro.defaultMessage
            erros[fieldName] = messageError
        }
        return  ResponseEntity(
            ExceptionsDetails(
                title = "Bad Request! Consult the documentation",
                timestamp = LocalDate.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exception = ex.javaClass.toString(),
                details = erros
            ), HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(DataAccessException::class)
    fun handlerValidException(ex: DataAccessException): ResponseEntity<ExceptionsDetails>{
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(
            ExceptionsDetails(
                title = "Bad Request! Consult the documentation",
                timestamp = LocalDate.now(),
                status = HttpStatus.CONFLICT.value(),
                exception = ex.javaClass.toString(),
                details = mutableMapOf(ex.cause.toString() to ex.message)
            )
        )
    }

    @ExceptionHandler(BusinessException::class)
    fun handlerValidException(ex: BusinessException): ResponseEntity<ExceptionsDetails>{
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ExceptionsDetails(
                title = "Bad Request! Consult the documentation",
                timestamp = LocalDate.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exception = ex.javaClass.toString(),
                details = mutableMapOf(ex.cause.toString() to ex.message)
            )
        )
    }
}