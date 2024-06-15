package com.gfg.thread;

public class RunnableDemo {


    public static void main(String[] args) {

        MyTask myTask = new MyTask();
        myTask.run();

        Thread thread = new Thread(myTask);
        thread.setName("Worker-01");



        Thread thread2 = new Thread(myTask);
        thread2.setName("Worker-02");

        thread.start();
        thread2.start();

    }
}
