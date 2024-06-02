package com.gfg;

import java.util.Date;

public class TransientDemo {

    public static void main(String[] args) {

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
    }
}

class Employee{

    private String name;
    private Date doj;
    transient private Long serviceDuration;
    public Employee() {
    }
}
