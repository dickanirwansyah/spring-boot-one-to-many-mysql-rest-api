package com.spring.app.springbootangularcore.controller;

import com.spring.app.springbootangularcore.entity.Employee;
import com.spring.app.springbootangularcore.exception.NotFoundException;
import com.spring.app.springbootangularcore.repository.DepartemenRepository;
import com.spring.app.springbootangularcore.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartemenRepository departemenRepository;

    @PostMapping(value = "/create/{departemenId}/employee")
    public Employee create(@PathVariable("departemenId")long departemenId,
                           @Valid @RequestBody Employee employee){
       return departemenRepository.findById(departemenId)
               .map(departement -> {
                   employee.setDepartement(departement);
                   return employeeRepository.save(employee);
               }).orElseThrow(() -> new NotFoundException("sorry departemen id not found !"));
    }

    @PutMapping(value = "/update/{departemenId}/employee/{employeeId}")
    public Employee update(@PathVariable("departemenId")long departemenId,
                           @PathVariable("employeeId")String employeeId,
                           @RequestBody Employee requestEmployee){

       return departemenRepository.findById(departemenId)
               .map(departement -> {
                   //requestEmployee.setDepartement(departement);
                   return employeeRepository.findById(employeeId)
                           .map(employee -> {
                               employee.setSalary(requestEmployee.getSalary());
                               employee.setFirstname(requestEmployee.getFirstname());
                               employee.setLastname(requestEmployee.getLastname());
                               employee.setAge(requestEmployee.getAge());
                               employee.setDepartement(departement);
                               return employeeRepository.save(employee);
                           }).orElseThrow(() -> new NotFoundException("sorry empolyee id notfound"));
               }).orElseThrow(()-> new NotFoundException("sorry departemen id "+departemenId+" not found"));
    }

    @DeleteMapping(value = "/delete/{departemenId}/employee/{employeeId}")
    public ResponseEntity<?> delete(@PathVariable("departemenId")long departemenId,
                                    @PathVariable("employeeId")String employeeId){

        return departemenRepository.findById(departemenId)
                .map(departement -> {
                    return employeeRepository.findById(employeeId)
                            .map(employee -> {
                                employeeRepository.delete(employee);
                                return ResponseEntity.ok().build();
                            }).orElseThrow(()-> new NotFoundException("employee id not found"));
                }).orElseThrow(() -> new NotFoundException("departement id "+departemenId+" not found"));
    }
}
