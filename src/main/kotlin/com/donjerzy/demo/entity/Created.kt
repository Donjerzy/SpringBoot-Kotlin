package com.donjerzy.demo.entity

data class Created(
    val httpStatus : Int,
    val message: String,
    var departmentCreated:Department
)
