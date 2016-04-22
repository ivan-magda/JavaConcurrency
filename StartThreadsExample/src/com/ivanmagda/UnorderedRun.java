package com.ivanmagda;

public class UnorderedRun extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void example() {
        for (int i = 0; i < 10; ++i) {
            Thread thread = new UnorderedRun();
            thread.start();
        }
    }

}
