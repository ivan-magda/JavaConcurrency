package com.ivanmagda;

/**
 * Thread Deadlock
 * <p>
 * <p>
 * A deadlock is when two or more threads are blocked waiting to obtain locks that some of the
 * other threads in the deadlock are holding. Deadlock can occur when multiple threads need the
 * same locks, at the same time, but obtain them in different order.
 * <p>
 * For instance, if thread 1 locks A, and tries to lock B, and thread 2 has already locked B,
 * and tries to lock A, a deadlock arises. Thread 1 can never get B, and thread 2 can never
 * get A. In addition, neither of them will ever know. They will remain blocked on each their
 * object, A and B, forever. This situation is a deadlock.
 * <p>
 * The situation is illustrated below:
 * Thread 1  locks A, waits for B
 * Thread 2  locks B, waits for A
 */

public class Main {

    public static void main(String[] args) {
    }
}
