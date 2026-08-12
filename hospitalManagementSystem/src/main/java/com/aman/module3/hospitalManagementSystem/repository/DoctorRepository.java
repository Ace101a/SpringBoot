package com.aman.module3.hospitalManagementSystem.repository;

import com.aman.module3.hospitalManagementSystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}