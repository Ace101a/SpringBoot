package com.aman.module3.hospitalManagementSystem.repository;

import com.aman.module3.hospitalManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}