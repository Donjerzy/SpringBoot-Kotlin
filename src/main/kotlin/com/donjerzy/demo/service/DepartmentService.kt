package com.donjerzy.demo.service

import com.donjerzy.demo.entity.Department


interface DepartmentService {
     fun saveDepartment(department: Department): Department

     fun getAllDepartments(): List<Department>

     fun getDepartmentByID(id: Long): Department

     fun deleteDepartmentById(id: Long)

     fun updateDepartmentRecord(id: Long, department: Department):Department
}