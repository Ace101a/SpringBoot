package com.aman.springbootweb.Controllers;

import com.aman.springbootweb.DTO.EmployeeDTO;
import com.aman.springbootweb.entities.EmployeeEntity;
import com.aman.springbootweb.repository.EmployeeRepository;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    //not recommended to link controller and repository(persistence layer) without intermediate service layer.
    // doing for learning purpose
    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name="employeeId") Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping //  we can remove as added the employee as parent path  using @RequestMapping/employee
    public List<EmployeeEntity> getEmployeeAge(@RequestParam(required = false) Integer age, @RequestParam (required = false) String sortBy){
        return employeeRepository.findAll();
    }

    @PostMapping("/setEmp")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity inputEmp){
        return employeeRepository.save(inputEmp);
    }



//    @GetMapping("/{employeeId}")
//    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){
//        return new EmployeeDTO(employeeId,"Aman","ar334060",22, LocalDate.of(2026,6,23),true);
//    }
//
//
//    @GetMapping //  we can remove as added the employee as parent path  using @RequestMapping/employee
//    public String getEmployeeAge(@RequestParam(required = false) Integer age,@RequestParam (required = false) String sortBy){
//        return "Hi my age is : "+age + " "+sortBy;
//    }
//
//    @PostMapping
//    public String postReq(){
//        return "hello";
//    }
//
//    @PostMapping("/setEmp")
//    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmp){
//        inputEmp.setId(100L);
//        return inputEmp;
//    }


    @PutMapping
    public String putReq(){
        return "putted";
    }

}
