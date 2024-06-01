package com.gfg;

import java.util.Date;

public final class Employee {

    private String name;

    private Date doj;

    String details;

    public Employee(String name, Date doj) {
        this.name = name;
        this.doj = new Date(doj.getTime());;
    }

    public String getName() {
        return name;
    }


    public Date getDoj() {
        //return doj;
        return new Date(doj.getTime());
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", doj=" + doj +
                '}';
    }
}
