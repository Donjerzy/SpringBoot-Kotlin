package com.donjerzy.demo.service

import com.donjerzy.demo.entity.Department
import com.donjerzy.demo.repository.DepartmentRepository
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
internal class DepartmentServiceImplTest {

    @Autowired
    lateinit var departmentServiceImpl: DepartmentServiceImpl

    @MockBean
    lateinit var departmentRepository: DepartmentRepository


    @BeforeEach
    fun setUp() {

        val department = Department(1,
            "Computer Science Department",
        "Kodi 2 Road",
        "CSD")

        Mockito.`when`(departmentRepository.
        findByDepartmentNameIgnoreCase("Computer Science Department")).
                thenReturn(department)

        Mockito.`when`(departmentRepository.findByDepartmentNameIgnoreCase("Biology Department")).thenReturn(null)



    }

    @Test
    @DisplayName("Positive find Department by Name")
    fun whenValidDepartmentNameThenDepartmentShouldFound(){

        val departmentName ="Computer Science Department"

        val fetchedDepartment:Department = departmentServiceImpl.fetchDepartmentByName(departmentName)

        assertEquals(fetchedDepartment.departmentName, departmentName)

    }


    @Test
    @DisplayName("Negative find Department by Name")
    fun whenInvalidDepartmentNameThenDepartmentShouldNotBeFound(){

        val departmentName ="Biology Department"

        val fetchedDepartment:Department = departmentServiceImpl.fetchDepartmentByName(departmentName)

        assertNull(fetchedDepartment)

    }

}