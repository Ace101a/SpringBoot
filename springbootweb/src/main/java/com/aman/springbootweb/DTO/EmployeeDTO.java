package com.aman.springbootweb.DTO;

import com.aman.springbootweb.annotation.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    //@NotNull(message = "Name is required")
    //@NotEmpty //it allows space blanks so its not empty means there should be something can be space
    @NotBlank
    @Size(min = 2,max = 20,message = "Number of characters in name should be in range : [2,20]")
    private String name;
    @Email(message = "Enter a valid mail")
    private String email;

    @NotNull
    @Max(value =80,message = "Age should be less than 80")
    @Min(value = 18,message = "Age must be greater than 18")
    private Integer age;

    @NotNull
    @Positive(message = "can not be negative")
    @Digits(integer = 6,fraction = 2,message = "Can have onle 6 digits in integer and 2 in fraction")
    @DecimalMax(value = "10000.99")//value must be less than this
    @DecimalMin(value = "50.10")//Atleast this much
    private Double salary;

    private LocalDate dateOfJoining;

    @NotBlank
    //@Pattern(regexp = "^(ADMIN|USER)$")
    @EmployeeRoleValidation
    private String role;


    @AssertTrue(message = "Only active employees are allowed")
    private Boolean isActive;

//    public EmployeeDTO(){
//
//    }
//
//    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate dateOfJoining, Boolean isActive) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.age = age;
//        this.dateOfJoining = dateOfJoining;
//        this.isActive = isActive;
//    }
//    @JsonProperty("isActive")
//    public Boolean getActive() {
//        return isActive;
//    }
//
//    public void setActive(Boolean active) {
//        isActive = active;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public LocalDate getDateOfJoining() {
//        return dateOfJoining;
//    }
//
//    public void setDateOfJoining(LocalDate dateOfJoining) {
//        this.dateOfJoining = dateOfJoining;
//    }
//
}
