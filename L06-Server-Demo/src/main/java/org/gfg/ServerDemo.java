package org.gfg;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerDemo {

    public static void main(String[] args) {

        System.out.println("Starting server");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Enter Request Data");
            String data = sc.nextLine();
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        System.out.println("Processing "+data+" in thread:"+Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

    }
}
