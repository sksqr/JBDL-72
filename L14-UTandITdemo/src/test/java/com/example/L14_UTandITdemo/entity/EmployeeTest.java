package com.example.L14_UTandITdemo.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EmployeeTest {


    @Test
    public void testNameSetter(){
        Employee employee = new Employee();
        String name = "Ravi";
        employee.setName(name);
        assertThat(employee.getName()).isEqualTo(name);
    }

    @Test
    public void testEmailSetter(){
        Employee employee = new Employee();
        String email = "Ravi@yopmail.com";
        employee.setEmail(email);
        assertThat(employee.getEmail()).isEqualTo(email);
    }
}
