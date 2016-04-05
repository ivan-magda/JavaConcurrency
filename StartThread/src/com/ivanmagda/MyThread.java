package com.ivanmagda;

/**
 * Subclass of Thread that overrides the run() method.
 * The run() method is what is executed by the thread after called start().
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());

        System.out.println("Hello, I'm custom thread!!!");
    }
}
