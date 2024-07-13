package com.example.L11_Spring_JPA_EntityManager_Demo.repo;


import com.example.L11_Spring_JPA_EntityManager_Demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);

    Employee findByEmailAndName(String email, String name);

    @Procedure(value = "GetTopPerformingEmployeeByYear")
    Employee findTopEmployeeByYear(int year);
}
