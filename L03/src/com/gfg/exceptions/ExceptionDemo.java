package com.gfg.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionDemo {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scanner.next();
//        System.out.println(name.charAt(2));
        if(name.length() > 2){
            System.out.println(name.charAt(2));
        }
        else {
            System.out.println("Name length is less than 2");
        }


        readFromFile();


    }

    private static void readFromFile() /*throws FileNotFoundException*/ {

        FileReader fileReader = null;
        try {
            fileReader = new FileReader("/tmp/test01.txt");
            int a = fileReader.read();
            System.out.println(a);
            System.out.println("Done File reading");

        }catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            throw new RuntimeException(e);
        }catch (IOException e) {
            System.out.println("IOException");
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Executing finally");
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        try {
            FileReader fileReader1 = new FileReader("/tmp/test03.txt");
            int a = fileReader1.read();
            fileReader1.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }

        //  FileReader fileReader = new FileReader("/tmp/test01.txt");

    }


    private void demoTryWithResource(){

        try (FileReader fileReader = new FileReader("/tmp/test03.txt")){
            int a = fileReader.read();
            System.out.println(a);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}


