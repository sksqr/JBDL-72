package com.gfg.thread;

import java.util.Scanner;

public class MultiThreadDemo {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());
        System.out.println("Hello");
        System.out.println("Enter your name");
        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine();
//        if(name.equals("abc")){
//            System.out.println("Hello abc");
//        }
        System.out.println("bye!");
        System.out.println(Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        myThread.setName("MyThread-01");
        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done by: "+Thread.currentThread().getName());

    }
}
