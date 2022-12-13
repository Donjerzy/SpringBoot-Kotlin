package com.donjerzy.demo.service

import com.donjerzy.demo.entity.Department
import com.donjerzy.demo.error.BlankDepartmentNameException
import com.donjerzy.demo.error.DepartmentNotFoundException
import com.donjerzy.demo.repository.DepartmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional


@Service
class DepartmentServiceImpl : DepartmentService {

    @Autowired
    lateinit var departmentRepository: DepartmentRepository




    override fun saveDepartment(department: Department): Department{

        if(department.departmentName.isBlank()){
            throw BlankDepartmentNameException("Department Name cannot be blank")
        }else {
            return departmentRepository.save(department)
        }

    }

    override fun getAllDepartments(): List<Department> {
        return departmentRepository.findAll()
    }

    override fun getDepartmentByID(id: Long): Department {
       val dep : Optional<Department> = departmentRepository.findById(id)
       if(!dep.isPresent){
           throw DepartmentNotFoundException("Department does not exist")
       }else{
           return dep.get()
       }

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

    override fun fetchDepartmentByName(name: String): Department {
        return departmentRepository.findByDepartmentNameIgnoreCase(name)

    }


}