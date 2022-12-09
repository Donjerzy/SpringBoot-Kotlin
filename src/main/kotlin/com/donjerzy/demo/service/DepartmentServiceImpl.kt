package com.donjerzy.demo.service

import com.donjerzy.demo.entity.Department
import com.donjerzy.demo.repository.DepartmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class DepartmentServiceImpl : DepartmentService {

    @Autowired
    lateinit var departmentRepository: DepartmentRepository


    override fun saveDepartment(department: Department): Department{
        return departmentRepository.save(department)
    }

    override fun getAllDepartments(): List<Department> {
        return departmentRepository.findAll()
    }

    override fun getDepartmentByID(id: Long): Department {
        return departmentRepository.findById(id).get()
    }

    override fun deleteDepartmentById(id: Long) {
        return departmentRepository.deleteById(id)
    }

    override fun updateDepartmentRecord(id: Long, department: Department):Department {
        val departmentInstance : Department = departmentRepository.findById(id).get()

        if (department.departmentName.isNotEmpty() && department.departmentName.isNotBlank()){
            departmentInstance.departmentName = department.departmentName
        }

        if (department.departmentAddress.isNotEmpty() && department.departmentAddress.isNotBlank()){
            departmentInstance.departmentAddress = department.departmentAddress
        }

        if (department.departmentCode.isNotEmpty() && department.departmentCode.isNotBlank()){
            departmentInstance.departmentCode = department.departmentCode
        }

        return departmentRepository.save(departmentInstance)




    }

}