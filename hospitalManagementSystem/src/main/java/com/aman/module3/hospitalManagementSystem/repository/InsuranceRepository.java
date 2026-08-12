package com.aman.module3.hospitalManagementSystem.repository;

import com.aman.module3.hospitalManagementSystem.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}