package com.gfg;

import java.util.Date;

public class EncapsulationDemo {

    public static void main(String[] args) {

        Lecture l1 = new Lecture();
        l1.setName("L01");
        l1.setMentor("Shashi");
        l1.setStatus("Upcoming");

        System.out.println(l1);
        l1.getName();

        l1.setName("Lecture-01");
        l1.setStatus("Live");

        l1.setStatus("Eating");

        l1.status="Eating";
        System.out.println(l1);

        //default
        Employee employee = new Employee("test", new Date());
        employee.details="Test emp";
        System.out.println(employee.details);
    }
}
