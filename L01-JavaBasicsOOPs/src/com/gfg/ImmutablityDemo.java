package com.gfg;

import java.util.Date;

public class ImmutablityDemo {

    public static void main(String[] args) {

        String name = new String("Shashi");
        String name2 = name;
        System.out.println(name);
        System.out.println(name2);
        name2 = new String("ravi");
        name.substring(0,3);
        System.out.println(name);
        System.out.println(name2);

        Date date = new Date();
        Employee emp1 = new Employee("Emp1",date);
        System.out.println(emp1);
//        emp1.setName("Test");
//        emp1.name="Test";

        emp1.getDoj().setTime(89797656457l);
        date.setTime(89797656457l);

        System.out.println(emp1.getDoj());

        System.out.println(emp1);
    }
}
