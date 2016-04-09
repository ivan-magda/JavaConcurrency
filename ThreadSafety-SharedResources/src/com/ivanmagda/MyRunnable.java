package com.ivanmagda;

public class MyRunnable implements Runnable {
    NotThreadSafe notThreadSafe = null;

    public MyRunnable(NotThreadSafe instance) {
        notThreadSafe = instance;
    }

    @Override
    public void run() {
        notThreadSafe.add("Adding some test text");
    }
}
