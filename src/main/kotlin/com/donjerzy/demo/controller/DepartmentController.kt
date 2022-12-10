package com.donjerzy.demo.controller

import com.donjerzy.demo.entity.Department
import com.donjerzy.demo.service.DepartmentService
import com.donjerzy.demo.service.DepartmentServiceImpl
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class DepartmentController {

    @Autowired
    lateinit var departmentServiceImpl:DepartmentServiceImpl


    @PostMapping("/save-department")
    fun saveDepartment(@Valid @RequestBody department: Department): Department{
        return departmentServiceImpl.saveDepartment(department)

    }

    @GetMapping("/all-departments")
    fun getDepartmentsList():List<Department>{
        return departmentServiceImpl.getAllDepartments()
    }

    @GetMapping("/department-by-id/{id}")
    fun getDepartmentByID(@PathVariable id :Long): Department {
        return departmentServiceImpl.getDepartmentByID(id)
    }

    @DeleteMapping("/delete-department-by-id/{id}")
    fun deleteDepartmentByID(@PathVariable id: Long): String{
        departmentServiceImpl.deleteDepartmentById(id)
         return "department with id $id has been deleted successfully"
    }

    @PutMapping("/update-department-by-id/{id}")
    fun updateDepartmentRecord(@PathVariable id: Long, @RequestBody department: Department): Department{
        return departmentServiceImpl.updateDepartmentRecord(id,department)
    }

    @GetMapping("/fetch-department-by-name/{name}")
    fun fetchDepartmentByName(@PathVariable name: String): Department{
        return departmentServiceImpl.fetchDepartmentByName(name)
    }





}