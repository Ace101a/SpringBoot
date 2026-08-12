package com.aman.module3.hospitalManagementSystem.repository;

import com.aman.module3.hospitalManagementSystem.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}