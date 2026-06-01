package com.aman.springbootweb.Controllers;

import com.aman.springbootweb.DTO.EmployeeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController

public class EmployeeController {
    @GetMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){
        return new EmployeeDTO(employeeId,"Aman","ar334060",22, LocalDate.of(2026,6,23),true);
    }

}
