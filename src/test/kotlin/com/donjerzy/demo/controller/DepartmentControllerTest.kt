package com.donjerzy.demo.controller

import com.donjerzy.demo.entity.Department
import com.donjerzy.demo.service.DepartmentServiceImpl
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest
internal class DepartmentControllerTest {

    @Autowired
    lateinit var mocMvc:MockMvc

    @MockBean
    lateinit var serviceImpl: DepartmentServiceImpl


    lateinit var department: Department

    @BeforeEach
    fun setUp() {
        department = Department(7,"Science","Kodi","SC")


    }

    @Test
    fun saveDepartmentShouldReturnTheSameDepartmentIFTrue(){
        val dep = Department(departmentName = "Science", departmentAddress = "Kodi", departmentCode = "SC", departmentID = 7)
        val saved =  serviceImpl.saveDepartment(dep)

        Mockito.`when`(serviceImpl.saveDepartment(dep)).thenReturn(department)

        mocMvc.perform(MockMvcRequestBuilders.post("/alt-save")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\n" +
                    "    \n" +
                    "    \"departmentName\" : \"Science\",\n" +
                    "    \"departmentAddress\": \"Kodi\",\n" +
                    "    \"departmentCode\": \"SC\",\n" +
                    "    \"departmentID\": \"7\"\n" +
                    "}")
            ).andExpect(MockMvcResultMatchers.status().isOk)

    }

    @Test
    fun whenFetchDepartmentByIdReturnTheRelevantDepartment(){
        Mockito.`when`(serviceImpl.getDepartmentByID(7)).thenReturn(Department(departmentName = "Science", departmentAddress = "Kodi", departmentCode = "SC", departmentID = 7)
        )

        mocMvc.perform(MockMvcRequestBuilders.get("/department-by-id/7",)
            .contentType(MediaType.APPLICATION_JSON)
            ).andExpect(MockMvcResultMatchers.status().isOk)

    }

}