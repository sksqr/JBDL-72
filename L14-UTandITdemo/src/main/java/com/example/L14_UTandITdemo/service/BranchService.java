package com.example.L14_UTandITdemo.service;


import com.example.L14_UTandITdemo.entity.Branch;
import com.example.L14_UTandITdemo.repo.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService {

    @Autowired
    private BranchRepo branchRepo;

    public Branch create(Branch branch){
        branch = branchRepo.save(branch);
        return branch;
    }

    public Branch get(Long id){
        Branch branch= branchRepo.findById(id).get();
        System.out.println("--------");
        branch= branchRepo.findById(id).get();
        return branch;
    }
}
