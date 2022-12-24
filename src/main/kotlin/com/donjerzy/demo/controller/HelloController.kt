package com.donjerzy.demo.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @Value("\${welcome.message}")
    lateinit var welcomeMessage:String

    @GetMapping("/welcome")
    fun helloWorld(): String = welcomeMessage
}