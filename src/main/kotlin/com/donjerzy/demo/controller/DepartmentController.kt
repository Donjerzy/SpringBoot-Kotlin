package com.donjerzy.demo.controller

import com.donjerzy.demo.entity.Created
import com.donjerzy.demo.entity.Department
import com.donjerzy.demo.error.BlankDepartmentNameException
import com.donjerzy.demo.service.DepartmentService
import com.donjerzy.demo.service.DepartmentServiceImpl
import jakarta.validation.Valid
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
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

    // logger used to debug
    var logger: Logger = LoggerFactory.getLogger(DepartmentController::class.java)

    @PostMapping("/save-department")

        fun saveDepartment(@RequestBody department: Department): Department {
            return departmentServiceImpl.saveDepartment(department)

        }


    @PostMapping("/alt-save")
    fun savDepartment(@RequestBody department: Department): ResponseEntity<Any> {
        val dep = departmentServiceImpl.saveDepartment(department)

        val depCreated: Created = Created(200,"Department has successfully been created",dep)

        return ResponseEntity.ok().body(depCreated)



    }



    @GetMapping("/all-departments")
    fun getDepartmentsList():List<Department>{
        logger.info("Inside all departments")
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