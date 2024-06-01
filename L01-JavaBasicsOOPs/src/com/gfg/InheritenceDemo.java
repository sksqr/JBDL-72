package com.gfg;

public class InheritenceDemo {

    public static void main(String[] args) {
        //Teacher teacher = new Teacher("Rakesh", 30, "Maths");

        RandomTeacher randomTeacher = new RandomTeacher("Maths");
        randomTeacher.setName("RandomName");
        randomTeacher.walk();

        Teacher teacher = new Teacher("Math");
        teacher.setName("Rakesh");
        teacher.setAge(30);
        teacher.walk();

        Person person = new Person();
        person.setName("Ravi");
        person.walk();

        //Subclass to superclass
        Person person1 = new Teacher("English");
        person1.setName("Neeraj");
        person1.walk();

        System.out.println(person1 instanceof Teacher);
        System.out.println(person1 instanceof Person);
        System.out.println(person1 instanceof Object);
        Teacher teacher1 = (Teacher)person1;
        teacher1.walk();

        System.out.println(person instanceof Teacher);
        //Superclass to subclass
        Teacher teacher2 = (Teacher)person;
        teacher2.walk();

    }
}
