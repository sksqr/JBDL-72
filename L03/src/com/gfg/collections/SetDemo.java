package com.gfg.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {

        List<String> studentsList = new ArrayList<>();
        studentsList.add("Neeraj");
        studentsList.add("Deeraj");
        studentsList.add("Deeraj");
        System.out.println(studentsList);

        Set<String> studentsSet = new HashSet<>();
        studentsSet.add("Neeraj");
        studentsSet.add("Deeraj");
        studentsSet.add("Deeraj");
        studentsSet.add("Neeraj");
        System.out.println(studentsSet);

    }
}
