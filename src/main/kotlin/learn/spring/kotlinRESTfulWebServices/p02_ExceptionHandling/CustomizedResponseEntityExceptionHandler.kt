package learn.spring.kotlinRESTfulWebServices.p02_ExceptionHandling

import learn.spring.RESTfulWebServices.p02_ExceptionHandling.ErrorDetails
import learn.spring.RESTfulWebServices.p02_ExceptionHandling.UserNotFoundException
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
class CustomizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    @Throws(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<ErrorDetails> {
        val errorDetails: ErrorDetails = ErrorDetails(
            LocalDateTime.now(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(UserNotFoundException::class)
    @Throws(UserNotFoundException::class)
    fun handleUserNotFound(ex: UserNotFoundException, request: WebRequest): ResponseEntity<ErrorDetails> {
        val errorDetails: ErrorDetails = ErrorDetails(
            LocalDateTime.now(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity(errorDetails, HttpStatus.NOT_FOUND)
    }
}