package com.example.L11_Spring_JPA_EntityManager_Demo.controller;


import com.example.L11_Spring_JPA_EntityManager_Demo.dto.EmployeeDetailReq;
import com.example.L11_Spring_JPA_EntityManager_Demo.entity.Address;
import com.example.L11_Spring_JPA_EntityManager_Demo.entity.Employee;
import com.example.L11_Spring_JPA_EntityManager_Demo.exception.IdCardNotAllocatedException;
import com.example.L11_Spring_JPA_EntityManager_Demo.exception.LaptopNotAllocatedException;
import com.example.L11_Spring_JPA_EntityManager_Demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> createAdd(@RequestBody Address address) throws LaptopNotAllocatedException, IdCardNotAllocatedException {
        address = addressService.createAddress(address);
        return ResponseEntity.ok(address);
    }

}
