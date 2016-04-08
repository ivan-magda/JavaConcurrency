package com.ivanmagda;

public class Counter {

    protected long count = 0;

    // Critical section example that may fail
    // if executed by multiple threads simultaneously.
    public void add(long value) {
        this.count += value;
    }
}
