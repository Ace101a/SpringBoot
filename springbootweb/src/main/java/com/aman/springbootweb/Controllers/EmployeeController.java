package com.aman.springbootweb.Controllers;

import com.aman.springbootweb.DTO.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){
        return new EmployeeDTO(employeeId,"Aman","ar334060",22, LocalDate.of(2026,6,23),true);
    }


    @GetMapping //  we can remove as added the employee as parent path  using @RequestMapping/employee
    public String getEmployeeAge(@RequestParam(required = false) Integer age,@RequestParam (required = false) String sortBy){
        return "Hi my age is : "+age + " "+sortBy;
    }

    @PostMapping
    public String postReq(){
        return "hello";
    }

    @PostMapping("/setEmp")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmp){
        inputEmp.setId(100L);
        return inputEmp;
    }


    @PutMapping
    public String putReq(){
        return "putted";
    }

}
