package com.gfg.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class VisitorCounterTask implements Runnable{
    private int count;

    private AtomicInteger atomicInteger =new AtomicInteger();

//    private synchronized void increment(){
//        count++;
//    }

    private  void increment(){
        count++;
        atomicInteger.incrementAndGet();
    }


    @Override
    public void run() {
        increment();;
    }

    @Override
    public String toString() {
        return "VisitorCounterTask{" +
                "count=" + count +
                ", atomicInteger=" + atomicInteger +
                '}';
    }
}
