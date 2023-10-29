package dio.lyusk8.credit.application.system.exceptions

data class BusinessException(override val message: String?) : RuntimeException(message)
