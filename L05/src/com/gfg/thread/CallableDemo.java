package com.gfg.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) {


//        Callable<String> callable = new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                //make api call
//                return "FlightDate";
//            }
//        };

        Callable<String> callable = () -> {
            System.out.println("Executing in "+Thread.currentThread().getName());
            //make api call
            return "FlightData";
        };

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> futureData =  executorService.submit(callable);
        try {
            System.out.println(futureData.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        List<Callable<String>> callableList = new LinkedList<>();
        callableList.add(callable);
        callableList.add(callable);
        callableList.add(callable);
        try {
            List<Future<String>> futureList = executorService.invokeAll(callableList);
            for(Future<String> future: futureList){
                System.out.println(future.get());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
