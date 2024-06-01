package com.gfg;

public class RandomTeacher extends Teacher{
    public RandomTeacher(String subject) {
        super(subject);
    }

    public void walk(){
        super.walk();
        System.out.println("Random walk");
    }
}
