package org.example;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws Exception {

        /// Task1
//        Runnable runnable = () -> {
//            System.out.println("Running " + Thread.currentThread().getName() + " ....");
//            for(int i = 1; i < 6; i++) {
//                try {
//                    System.out.println(Thread.currentThread().getName() + ": " + i);
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };
//
//        // Thread 1
//        Thread thread1 = new Thread(runnable, "Worker-1");
//
//        // Thread 2
//        Thread thread2 = new Thread(runnable, "Worker-2");
//
//        thread1.start();
//        thread2.start();
//
//        // Here I told to Main Thread hold(wait) until thread1 finish
//        thread1.join();
//        // Here I told to Main Thread hold(wait) until thread2 finish
//        thread2.join();
//
//        System.out.println("Running Main Thread ....");

        ///  Task 2
//        Callable<Integer> callable = () -> {
//            int sum = 0;
//            for(int i = 1; i <= 100; i++) {
//                sum += i;
//            };
//            return sum;
//        };
//
//        int result = callable.call();
//        System.out.println(result);


        ///  Task 3
//        Counter counter = new Counter();
//
//        Runnable task = () -> {
//
//            for (int i = 0; i < 100_000; i++) {
//                counter.increment();
//            }
//        };
//
//        Thread t1 = new Thread(task, "Thread-1");
//        Thread t2 = new Thread(task, "Thread-2");
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
//
//        System.out.println("Final count = " + counter.getCount());

        // Create a worker thread
//        Thread worker = new Thread(() -> {
//            try {
//                while (!Thread.currentThread().isInterrupted()) {
//                    System.out.println("Working...");
//                    Thread.sleep(1000); // simulate doing work
//                }
//            } catch (InterruptedException e) {
//                System.out.println("Worker interrupted during sleep!");
//                // cleanup or exit gracefully
//            }
//            System.out.println("Worker exiting...");
//        });
//
//        worker.start();
//
//        System.out.println("Main Running ....");
//
//        // Let the worker run for 3 seconds
//        // Main Thread sleep for 3 seconds
//        Thread.sleep(3000);
//
//        System.out.println("Main thread: requesting interruption...");
//        worker.interrupt(); // politely ask worker to stop

    }
}