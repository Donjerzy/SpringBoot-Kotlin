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

   @field:NotBlank(message = "Department cannot be left blank")
   @field:Max(5, message = "Department name should not have more than 5 characters")
    var departmentName:String,
    var departmentAddress:String,
    var departmentCode:String
)