package com.aman.springbootweb.services;
import org.modelmapper.ModelMapper;
import com.aman.springbootweb.DTO.EmployeeDTO;
import com.aman.springbootweb.entities.EmployeeEntity;
import com.aman.springbootweb.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    public final EmployeeRepository employeeRepository;
    public final ModelMapper mapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        ModelMapper mapper = new ModelMapper();
        return mapper.map(employeeEntity, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getEmployeeAge() {
        List<EmployeeEntity> employeeEntities= employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> mapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList());

        }

    public EmployeeDTO createEmployee(EmployeeDTO inputEmp) {
        EmployeeEntity toSaveEntity = mapper.map(inputEmp, EmployeeEntity.class);
        EmployeeEntity employeeEntity = employeeRepository.save(toSaveEntity);
        return mapper.map(employeeEntity,EmployeeDTO.class);
    }
}
