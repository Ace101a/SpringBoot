package com.aman.springbootweb.services;
import com.aman.springbootweb.exceptions.ResourceNotFoundException;
import org.apache.el.util.ReflectionUtil;
import org.modelmapper.ModelMapper;
import com.aman.springbootweb.DTO.EmployeeDTO;
import com.aman.springbootweb.entities.EmployeeEntity;
import com.aman.springbootweb.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    public final EmployeeRepository employeeRepository;
    public final ModelMapper mapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }
    public void isExistsById(Long employeeId){
        boolean exits = employeeRepository.existsById(employeeId);
        if(!exits) throw new ResourceNotFoundException("Employee not found with id "+employeeId);
    }

//    public EmployeeDTO getEmployeeById(Long id) {
//        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
//        ModelMapper mapper = new ModelMapper();
//        return mapper.map(employeeEntity, EmployeeDTO.class);
//    }
public Optional<EmployeeDTO> getEmployeeById(Long id) {
//    Optional<EmployeeEntity> OptionalemployeeEntity = employeeRepository.findById(id);
//    return OptionalemployeeEntity.map(OptionalemployeeEntity1->mapper.map(OptionalemployeeEntity,EmployeeDTO.class));
    return employeeRepository.findById(id).map(employeeEntity -> mapper.map(employeeEntity,EmployeeDTO.class));
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

    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO) {
        isExistsById(employeeId);
        EmployeeEntity employeeEntity=mapper.map(employeeDTO,EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeId = employeeRepository.save(employeeEntity);
        return mapper.map(savedEmployeeId,EmployeeDTO.class);
    }

    public boolean DeleteEmployeeById(Long employeeId) {
        isExistsById(employeeId);
        employeeRepository.deleteById(employeeId);
        return true;
    }

    public EmployeeDTO updatePartiallyById(Long employeeId, Map<String, Object> updates) {
        isExistsById(employeeId);
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        updates.forEach((field,value)-> {
            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class,field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated,employeeEntity,value);
        });
        employeeRepository.save(employeeEntity);
        return mapper.map(employeeEntity,EmployeeDTO.class);
    }
}

