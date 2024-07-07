package com.example.L10_Spring_Data_JPA_And_Transactions_demo.service;

import com.example.L10_Spring_Data_JPA_And_Transactions_demo.dto.EmployeeDetailReq;
import com.example.L10_Spring_Data_JPA_And_Transactions_demo.entity.Address;
import com.example.L10_Spring_Data_JPA_And_Transactions_demo.entity.Branch;
import com.example.L10_Spring_Data_JPA_And_Transactions_demo.entity.Employee;
import com.example.L10_Spring_Data_JPA_And_Transactions_demo.exception.IdCardNotAllocatedException;
import com.example.L10_Spring_Data_JPA_And_Transactions_demo.exception.LaptopNotAllocatedException;
import com.example.L10_Spring_Data_JPA_And_Transactions_demo.repo.BranchRepo;
import com.example.L10_Spring_Data_JPA_And_Transactions_demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private BranchService branchService;

    private boolean isLaptopAllocated;

    private boolean isCardAllocated;

    public Employee createEmp(EmployeeDetailReq employeeDetailReq){
        Address address = new Address(null,employeeDetailReq.getLine1(),employeeDetailReq.getLine2(),employeeDetailReq.getCity());

        Branch branch = branchService.get(employeeDetailReq.getBranchId());

        //Employee employee = new Employee(null,employeeDetailReq.getName(),employeeDetailReq.getEmail(),address);
        Employee employee = Employee.builder()
                .name(employeeDetailReq.getName())
                .email(employeeDetailReq.getEmail())
                .address(address)
                .branch(branch)
                .build();

        employee = employeeRepo.save(employee);
        return employee;
    }

    @Transactional(rollbackFor = IdCardNotAllocatedException.class)
    public Employee createEmpWithTxn(EmployeeDetailReq employeeDetailReq) throws LaptopNotAllocatedException, IdCardNotAllocatedException {
        Address address = new Address(null,employeeDetailReq.getLine1(),employeeDetailReq.getLine2(),employeeDetailReq.getCity());

        Branch branch = branchService.get(employeeDetailReq.getBranchId());

        //Employee employee = new Employee(null,employeeDetailReq.getName(),employeeDetailReq.getEmail(),address);
        Employee employee = Employee.builder()
                .name(employeeDetailReq.getName())
                .email(employeeDetailReq.getEmail())
                .address(address)
                .branch(branch)
                .build();

        employee = employeeRepo.save(employee);
        // allocate laptop
        // API call to asset allocation service
        if(!isLaptopAllocated){
            throw new LaptopNotAllocatedException("Laptop not allocated");
        }
        // Create Id card
        if(!isCardAllocated){
            throw new IdCardNotAllocatedException("Card not allocated");
        }
        return employee;
    }

    public List<Employee> getAllEmp(){
        return employeeRepo.findAll();
    }

    public Employee byEmail(String email){
        Employee employee = employeeRepo.findByEmail(email);
        /*
        --
        --
        --
        if(){
         access address
        }
         */
        System.out.println(employee.getAddress().getLine1());
        return employee;
    }
}
