package com.ivanmagda;

/**
 * The ThreadLocal class in Java enables you to create variables that can only be read and
 * written by the same thread. Thus, even if two threads are executing the same code, and the
 * code has a reference to a ThreadLocal variable, then the two threads cannot see each other's
 * ThreadLocal variables.
 */

public class ThreadLocalExample {

    public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(threadLocal.get());
        }
    }

    public static void main(String[] args) {

        /**
         * This example creates a single MyRunnable instance which is passed to two different
         * threads. Both threads execute the run() method, and thus sets different values on the
         * ThreadLocal instance. If the access to the set() call had been synchronized, and it
         * had not been a ThreadLocal object, the second thread would have overridden the value
         * set by the first thread. However, since it is a ThreadLocal object then the two
         * threads cannot see each other's values. Thus, they set and get different values.
         */

        MyRunnable sharedRunnable = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnable);
        Thread thread2 = new Thread(sharedRunnable);

        thread1.start();
        thread2.start();

        // Wait for threads to terminate.
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
