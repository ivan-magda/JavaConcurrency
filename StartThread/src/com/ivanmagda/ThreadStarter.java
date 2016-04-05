package com.ivanmagda;

public class ThreadStarter {

    public static void main(String[] args) {
        // Create and start thread.
        MyThread thread = new MyThread();
        thread.start();

        // Create and start thread from class that implements Runnable.
        Thread runnableThread = new Thread(new MyRunnable(), "MyRunnableThread");
        System.out.println(runnableThread.getName());
        runnableThread.start();

        // Create an anonymous subclass of Thread.
        Thread anonymousThread = new Thread() {
            @Override
            public void run() {
                System.out.println("Anonymous thread running.");
            }
        };
        anonymousThread.start();
    }

}
