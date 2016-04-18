package com.ivanmagda;

/**
 * The Java volatile keyword is used to mark a Java variable as "being stored in main memory".
 * More precisely that means, that every read of a volatile variable will be read from the
 * computer's main memory, and not from the CPU cache, and that every write to a volatile
 * variable will be written to main memory, and not just to the CPU cache.
 *
 * Since Java 5 the volatile keyword guarantees more than just that volatile variables are
 * written to and read from main memory.
 *
 *
 * Use extended visibility guarantee to optimize the visibility of variables between threads.
 * Instead of declaring each and every variable volatile, only one or a few need be declared
 * volatile.
 *
 * Example of a simple Exchanger class written after that principle.
 */

public class Exchanger {

    private Object object = null;
    private volatile boolean hasNewObject = false;

    public void put(Object object) {
        while (hasNewObject) {
            // Wait - don't overwrite existing new object.
        }

        this.object = object;

        // Volatile write.
        hasNewObject = true;
    }

    public Object take() {
        // Volatile read.
        while (!hasNewObject) {

        }
        Object obj = object;

        // Volatile write.
        hasNewObject = false;

        return obj;
    }

}
