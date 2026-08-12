package com.aman.module3.hospitalManagementSystem;

import com.aman.module3.hospitalManagementSystem.entity.Patient;
import com.aman.module3.hospitalManagementSystem.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatient() {
//        List<Patient> patientList = patientRepository.findAll();
//        List<CPatientInfo> patientList = patientRepository.getAllPatientsInfoConcrete();
//        List<BloodGroupStats> patientList = patientRepository.getBloodGroupStats();
//
//        for(var p: patientList) {
//            System.out.println(p);
//        }

//        int rowsAffected = patientRepository.updatePatientNameWithId("Anuj Sharma", 1L);
//
//        System.out.println(rowsAffected);

        List<Patient> patientList = patientRepository.getAllPatientsWithAppointments();

        for(var p: patientList) {
            System.out.println(p);
        }
    }
}
