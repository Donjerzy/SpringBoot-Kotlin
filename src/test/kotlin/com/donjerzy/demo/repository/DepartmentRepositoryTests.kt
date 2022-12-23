package com.donjerzy.demo.repository

import com.donjerzy.demo.entity.Department
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager


@DataJpaTest
internal class DepartmentRepositoryTests {

    @Autowired
    lateinit var departmentRepository: DepartmentRepository

    @Autowired
    lateinit var testEntityManager: TestEntityManager

    @BeforeEach
    fun setUp(){

        val department = Department(1,
                                    "Bio-Tech",
                                    "452-Drive",
                                    "BT-452")


        testEntityManager.merge(department)

    }



    @Test
    fun whenFindDepartmentByValidIDReturnDepartment(){
       val dep =  departmentRepository.findById(1).get()
        assertEquals(dep.departmentName, "Bio-Tech")
    }




}