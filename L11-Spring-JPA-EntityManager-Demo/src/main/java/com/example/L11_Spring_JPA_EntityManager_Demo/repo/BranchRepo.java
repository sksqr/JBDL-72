package com.example.L11_Spring_JPA_EntityManager_Demo.repo;


import com.example.L11_Spring_JPA_EntityManager_Demo.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends JpaRepository<Branch,Long> {
}
