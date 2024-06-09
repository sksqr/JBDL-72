package com.gfg.collections;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        //Implementation of Heap
        // Min Heap: root element is minimum one.
        // Max Heap: root element is maximun one.
        // Heap Sort

        //Queue<Integer> integerQueue = new PriorityQueue<>();//min heap
        Queue<Integer> integerQueue = new PriorityQueue<>(Comparator.reverseOrder());
        integerQueue.add(2);
        integerQueue.add(1);
        integerQueue.offer(25);
        integerQueue.add(5);
        integerQueue.add(15);
        System.out.println(integerQueue);

        System.out.println(integerQueue.poll());
        System.out.println(integerQueue.poll());
        System.out.println(integerQueue.peek());
        System.out.println(integerQueue.peek());

        Product product1 = new Product("laptop",50000.00,4);
        Product product2 = new Product("pen",50.00,5);
        Product product3 = new Product("mouse",500.00,1);
        Product product4 = new Product("monitor",10000.00,3);

        PriorityQueue<Product> productPriorityQueue = new PriorityQueue<>();
        productPriorityQueue.add(product2);
        productPriorityQueue.add(product1);
        productPriorityQueue.add(product3);
        productPriorityQueue.add(product4);
        System.out.println(productPriorityQueue.poll());
        System.out.println(productPriorityQueue.poll());

        System.out.println("---------------");
        //Rating
//        PriorityQueue<Product> productPriorityQueueForRating = new PriorityQueue<>(new Comparator<Product>() {
//            @Override
//            public int compare(Product o1, Product o2) {
//                return o1.getRating().compareTo(o2.getRating());
//            }
//        });

      //  PriorityQueue<Product> productPriorityQueueForRating = new PriorityQueue<>((o1, o2) -> o1.getRating().compareTo(o2.getRating()));
        PriorityQueue<Product> productPriorityQueueForRating = new PriorityQueue<>(new ProductRatingComparator());

        productPriorityQueueForRating.add(product2);
        productPriorityQueueForRating.add(product1);
        productPriorityQueueForRating.add(product3);
        productPriorityQueueForRating.add(product4);
        System.out.println(productPriorityQueueForRating.poll());
        System.out.println(productPriorityQueueForRating.poll());


    }
}
