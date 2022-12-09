package com.donjerzy.demo.repository

import com.donjerzy.demo.entity.Department
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DepartmentRepository: JpaRepository<Department,Long> {
}