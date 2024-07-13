package com.example.L11_Spring_JPA_EntityManager_Demo.controller;

import com.example.L11_Spring_JPA_EntityManager_Demo.entity.Branch;
import com.example.L11_Spring_JPA_EntityManager_Demo.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping
    public ResponseEntity<Branch> createBranch(@RequestBody Branch branch){
        return ResponseEntity.ok(branchService.create(branch));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Branch> getBranch(@PathVariable Long id){
        Branch branch = branchService.get(id);
        return ResponseEntity.ok(branch);
    }
}
