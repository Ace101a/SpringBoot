package com.aman.springbootweb.Controllers;

import com.aman.springbootweb.DTO.EmployeeDTO;
import com.aman.springbootweb.entities.EmployeeEntity;
import com.aman.springbootweb.repository.EmployeeRepository;
import com.aman.springbootweb.services.EmployeeService;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.aspectj.apache.bcel.generic.LineNumberGen;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

//    private final EmployeeRepository employeeRepository;
//
//    public EmployeeController(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }
//    //not recommended to link controller and repository(persistence layer) without intermediate service layer.
//    // doing for learning purpose
//    @GetMapping("/{employeeId}")
//    public EmployeeEntity getEmployeeById(@PathVariable(name="employeeId") Long id) {
//        return employeeRepository.findById(id).orElse(null);
//    }
//
//    @GetMapping //  we can remove as added the employee as parent path  using @RequestMapping/employee
//    public List<EmployeeEntity> getEmployeeAge(@RequestParam(required = false) Integer age, @RequestParam (required = false) String sortBy){
//        return employeeRepository.findAll();
//    }
//
//    @PostMapping("/setEmp")
//    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity inputEmp){
//        return employeeRepository.save(inputEmp);
//    }


    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //not recommended to link controller and repository(persistence layer) without intermediate service layer.
    // doing for learning purpose
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name="employeeId") Long id) {
//        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
//        if(employeeDTO==null) return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(employeeDTO);
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElseThrow(()->new NoSuchElementException());

    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleEmployeeNotFound(NoSuchElementException exception){
        return new ResponseEntity<>("No such Employee with this id", HttpStatus.NOT_FOUND);
    }

    @GetMapping //  we can remove as added the employee as parent path  using @RequestMapping/employee
    public ResponseEntity<List<EmployeeDTO>> getEmployeeAge(@RequestParam(required = false) Integer age, @RequestParam (required = false) String sortBy){
        return ResponseEntity.ok(employeeService.getEmployeeAge());//no need for not found as it will return all employees
        //or return no employees empty list
    }



    @PostMapping("/setEmp")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody @Valid EmployeeDTO inputEmp){
        EmployeeDTO savedEmployee = employeeService.createEmployee(inputEmp);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
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


    @PutMapping(path ="/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO,@PathVariable Long employeeId){
        EmployeeDTO toUpdateEmployee =  employeeService.updateEmployeeById(employeeId,employeeDTO);
        return ResponseEntity.ok(toUpdateEmployee);
    }

    @DeleteMapping(path ="/{employeeId}")
    public ResponseEntity<Boolean> DeleteEmployeeById(@PathVariable Long employeeId){
        boolean gotDeleted = employeeService.DeleteEmployeeById(employeeId);
        if(gotDeleted == true) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path ="/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartiallyById(@RequestBody Map<String,Object> updates, @PathVariable Long employeeId){
        EmployeeDTO employeeDTO = employeeService.updatePartiallyById(employeeId,updates);
        if(employeeDTO==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }

}
