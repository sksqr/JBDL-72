package com.example.L14_UTandITdemo.service;

import com.example.L14_UTandITdemo.dto.EmployeeDetailReq;
import com.example.L14_UTandITdemo.entity.Address;
import com.example.L14_UTandITdemo.entity.Branch;
import com.example.L14_UTandITdemo.entity.Employee;
import com.example.L14_UTandITdemo.exception.IdCardNotAllocatedException;
import com.example.L14_UTandITdemo.exception.LaptopNotAllocatedException;
import com.example.L14_UTandITdemo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
   //@Autowired
    private EmployeeRepo employeeRepo;

    //@Autowired
    private BranchService branchService;

    public EmployeeService(EmployeeRepo employeeRepo, BranchService branchService) {
        this.employeeRepo = employeeRepo;
        this.branchService = branchService;
    }

    private boolean isLaptopAllocated = true;

    private boolean isCardAllocated = true;

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



    @Transactional
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
        System.out.println("---------------");
        System.out.println(employee.getAddress().getLine1());
        employee = employeeRepo.findByEmail(email);
        return employee;
    }
}
