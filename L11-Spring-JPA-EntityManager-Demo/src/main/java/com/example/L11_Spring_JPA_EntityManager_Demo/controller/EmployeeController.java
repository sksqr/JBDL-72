package com.example.L11_Spring_JPA_EntityManager_Demo.controller;


import com.example.L11_Spring_JPA_EntityManager_Demo.dto.EmployeeDetailReq;
import com.example.L11_Spring_JPA_EntityManager_Demo.entity.Address;
import com.example.L11_Spring_JPA_EntityManager_Demo.entity.Employee;
import com.example.L11_Spring_JPA_EntityManager_Demo.exception.IdCardNotAllocatedException;
import com.example.L11_Spring_JPA_EntityManager_Demo.exception.LaptopNotAllocatedException;
import com.example.L11_Spring_JPA_EntityManager_Demo.service.AddressService;
import com.example.L11_Spring_JPA_EntityManager_Demo.service.EmployeeService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @Autowired
    private AddressService addressService;


    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmp(){
        List<Employee> employees = employeeService.getAllEmp();
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmp(@RequestBody EmployeeDetailReq employeeDetailReq) throws LaptopNotAllocatedException, IdCardNotAllocatedException {
        Employee employee = employeeService.createEmp(employeeDetailReq);
        //Employee employee = employeeService.createEmpWithTxn(employeeDetailReq);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/byEmail")
    public ResponseEntity<Employee> getEmpByEmail(@RequestParam String email){
        Employee employee = employeeService.byEmail(email);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable Long id){
        Employee employee = employeeService.findById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/topPerformerByYear")
    public ResponseEntity<Employee> getTopPerformer(@RequestParam Integer year){
        Employee employee = employeeService.getTopEmp(year);
        return ResponseEntity.ok(employee);
    }


/*
Create Access Card for Employee
[Email, Id, branchId]
 */
}
