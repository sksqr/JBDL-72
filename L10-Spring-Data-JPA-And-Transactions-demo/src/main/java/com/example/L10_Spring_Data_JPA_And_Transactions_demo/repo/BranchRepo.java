package com.example.L10_Spring_Data_JPA_And_Transactions_demo.repo;

import com.example.L10_Spring_Data_JPA_And_Transactions_demo.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends JpaRepository<Branch,Long> {
}
