package com.aman.module3.hospitalManagementSystem;

import com.aman.module3.hospitalManagementSystem.entity.Appointment;
import com.aman.module3.hospitalManagementSystem.entity.Insurance;
import com.aman.module3.hospitalManagementSystem.service.AppointmentService;
import com.aman.module3.hospitalManagementSystem.service.InsuranceService;
import com.aman.module3.hospitalManagementSystem.service.PatientService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private PatientService patientService;

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testAssignInsuranceToPatient() {
        Insurance insurance = Insurance.builder()
                .provider("HDFC Ergo")
                .policyNumber("HDFC_23G")
                .validUntil(LocalDate.of(2030, 1, 1))
                .build();

        var updatedInsurance = insuranceService.assignInsuranceToPatient(insurance, 1L);

        System.out.println(updatedInsurance);

//        patientService.deletePatient(1L);

        var patient = insuranceService.removeInsuranceOfAPatient(1L);
        System.out.println(patient);
    }

    @Test
    public void testCreateAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025, 11, 1, 14, 0, 0))
                .reason("Cancer")
                .build();

        var updatedAppointment = appointmentService.createANewAppointment(appointment, 1L, 2L);
        System.out.println(updatedAppointment);

        patientService.deletePatient(1L);
    }
}
