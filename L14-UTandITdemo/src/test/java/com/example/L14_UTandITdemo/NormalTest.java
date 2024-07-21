package com.example.L14_UTandITdemo;

public class NormalTest {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        Integer a = 8;
        Integer b = 2;

        if(calculator.add(a,b) != (a+b)){
            System.out.println("Add Test Failed");
        }
        else {
            System.out.println("Add Test Pass");
        }


        if(calculator.multiply(a,b) != (a*b)){
            System.out.println("Multiply Test Failed");
        }
        else {
            System.out.println("Multiply Test Pass");
        }
    }
}
