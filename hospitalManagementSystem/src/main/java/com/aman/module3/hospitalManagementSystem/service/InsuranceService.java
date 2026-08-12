package com.aman.module3.hospitalManagementSystem.service;

import com.aman.module3.hospitalManagementSystem.entity.Insurance;
import com.aman.module3.hospitalManagementSystem.entity.Patient;
import com.aman.module3.hospitalManagementSystem.repository.InsuranceRepository;
import com.aman.module3.hospitalManagementSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance); // dirty patient

        insurance.setPatient(patient); //optional,
        return insurance;
    }

    @Transactional
    public Insurance updateInsuranceOfAPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance); // dirty patient

        insurance.setPatient(patient); //optional,
        return insurance;
    }

    @Transactional
    public Patient removeInsuranceOfAPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(null); // dirty patient

        return patient;
    }


}
