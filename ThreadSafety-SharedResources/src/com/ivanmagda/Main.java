package com.ivanmagda;

public class Main {

    public static void main(String[] args) {

        /**
         * Not thread safe example.
         *
         * If two threads call the add() method simultaneously on the same NotThreadSafe
         * instance then it leads to race conditions.
         * Because object member variables (fields) are stored on the heap along with the
         * object.
         */

        NotThreadSafe notThreadSafeInstance = new NotThreadSafe();

        // Two MyRunnable instances share the same NotThreadSafe instance.
        // Therefore, when they call the add() method on the NotThreadSafe instance it leads
        // to race condition.

        new Thread(new MyRunnable(notThreadSafeInstance)).start();
        new Thread(new MyRunnable(notThreadSafeInstance)).start();

        /**
         * Thread safe example.
         *
         * If two threads call the add() method simultaneously on different instances then it
         * does not lead to race condition.
         */

        new Thread(new MyRunnable(new NotThreadSafe())).start();
        new Thread(new MyRunnable(new NotThreadSafe())).start();
    }
}
