package com.gfg.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayDemo {

    public static void main(String[] args) {

        //arrayDemo();

        collectionDemo();



    }


    private static void collectionDemo(){
        List<String> studentsList = new ArrayList<>();
        studentsList.add("Neeraj");
        studentsList.add("Deeraj");

        System.out.println(studentsList);

        studentsList.add("Ajay");
        studentsList.add("Vijay");

        System.out.println(studentsList);
        Collections.sort(studentsList);
        System.out.println(studentsList);


    }


    private static void arrayDemo(){
        String[] students = new String[2];

        students[0]="Ravi";
        students[1]="Rahul";
        System.out.println(students);
        printArray(students);

        String[] temp = new String[4];
        int i=0;
        for(String string: students){
            temp[i] = students[i];
            i++;
        }
        students = temp;
        students[i]="Vijay";
        students[++i]="Ajay";

        printArray(students);
        Arrays.sort(students);


        printArray(students);

    }


    private static void printArray(String[] students){
        for(String student: students){
            System.out.println(student);
        }
    }
}
//CollectionFramework = DSA


