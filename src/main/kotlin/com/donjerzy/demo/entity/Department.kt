package com.donjerzy.demo.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Department(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var departmentID:Long,
    var departmentName:String,
    var departmentAddress:String,
    var departmentCode:String
)