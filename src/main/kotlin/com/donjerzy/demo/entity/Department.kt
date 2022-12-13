package com.donjerzy.demo.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length


@Entity
data class Department(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var departmentID:Long,
    var departmentName:String,
    var departmentAddress:String,
    var departmentCode:String
)