package com.neuroregenesis.neuroregenesisapp.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(IllegalStateException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handle(ex: IllegalStateException) =
        mapOf("error" to ex.message)
}
