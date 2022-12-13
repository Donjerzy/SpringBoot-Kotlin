package com.donjerzy.demo.error

import com.donjerzy.demo.entity.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.WebRequest
import com.donjerzy.demo.error.RestResponseEntityExceptionHandler

@ControllerAdvice
@ResponseStatus
class RestResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException::class)
    fun departmentNotFoundException(exception: DepartmentNotFoundException, request:WebRequest): ResponseEntity<ErrorMessage> {

        val errorMessage:ErrorMessage = ErrorMessage(HttpStatus.NOT_FOUND,exception.message.toString())

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage)

    }

    @ExceptionHandler(BlankDepartmentNameException::class)
    fun blankDepartmentName(exception: BlankDepartmentNameException, request: WebRequest): ResponseEntity<ErrorMessage>{

        val errorMessage = ErrorMessage(HttpStatus.BAD_REQUEST, exception.message.toString())

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage)
    }
}