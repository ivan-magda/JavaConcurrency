package com.ivanmagda;

public class Counter {

    protected long count = 0;

    /**
     * Adds value, using Java synchronized method.
     *
     * @param value - value to add to the count.
     */
    public synchronized void add(long value) {
        count += value;
    }
}
