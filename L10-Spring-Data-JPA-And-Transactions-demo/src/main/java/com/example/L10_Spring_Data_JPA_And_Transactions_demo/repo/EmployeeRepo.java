package com.example.L10_Spring_Data_JPA_And_Transactions_demo.repo;

import com.example.L10_Spring_Data_JPA_And_Transactions_demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);

    Employee findByEmailAndName(String email, String name);
}
