package com.example.L14_UTandITdemo.controller;


import com.example.L14_UTandITdemo.dto.EmployeeDetailReq;
import com.example.L14_UTandITdemo.entity.Employee;
import com.example.L14_UTandITdemo.exception.IdCardNotAllocatedException;
import com.example.L14_UTandITdemo.exception.LaptopNotAllocatedException;
import com.example.L14_UTandITdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmp(){
        List<Employee> employees = employeeService.getAllEmp();
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmp(@RequestBody EmployeeDetailReq employeeDetailReq) throws LaptopNotAllocatedException, IdCardNotAllocatedException {
        //Employee employee = employeeService.createEmp(employeeDetailReq);
        Employee employee = employeeService.createEmpWithTxn(employeeDetailReq);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/byEmail")
    public ResponseEntity<Employee> getEmpByEmail(@RequestParam String email){
        Employee employee = employeeService.byEmail(email);
        return ResponseEntity.ok(employee);
    }


/*
Create Access Card for Employee
[Email, Id, branchId]
 */
}
