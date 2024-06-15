package com.gfg.thread;

public class MemoryIssueDemo {

    public static void main(String[] args) {

        Signal signal = new Signal();

        Thread thread1 = new Thread(() -> {
            while (!signal.isStop()) {
                System.out.println("Executing in thread " + Thread.currentThread().getName());
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            signal.setStop(true);
            System.out.println("Setting to true in thread " + Thread.currentThread().getName());
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Done");


    }

}
