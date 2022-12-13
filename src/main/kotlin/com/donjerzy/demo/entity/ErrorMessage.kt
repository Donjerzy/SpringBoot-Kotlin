package com.donjerzy.demo.entity

import org.springframework.http.HttpStatus


data class ErrorMessage(
    var statusCode: HttpStatus,
    var message: String
)
