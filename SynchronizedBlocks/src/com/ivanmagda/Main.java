package com.ivanmagda;

public class Main {

    public static void main(String[] args) {

        /**
         * Two threads are created.
         * The same Counter instance is passed to both of them in their constructor.
         * The Counter.add() method is synchronized on the instance, because the add method is
         * an instance method, and marked as synchronized. Therefore only one of the threads can
         * call the add() method at a time. The other thread will wait until the first thread
         * leaves the add() method, before it can execute the method itself.
         */

        Counter counter = new Counter();
        CounterThread threadA = new CounterThread(counter);
        CounterThread threadB = new CounterThread(counter);

        threadA.start();
        threadB.start();

        /**
         * If the two threads had referenced two separate Counter instances, there would have
         * been no problems calling the add() methods simultaneously. The calls would have been
         * to different objects, so the methods called would also be synchronized on different
         * objects (the object owning the method). Therefore the calls would not block.
         *
         * sThreadA and sThreadB, no longer reference the same counter instance.
         * The add method of counterA and counterB are synchronized on their two owning
         * instances. Calling add() on counterA will thus not block a call to add() on counterB.
         */
        
        Counter counterA = new Counter();
        Counter counterB = new Counter();
        Thread sThreadA = new CounterThread(counterA);
        Thread sThreadB = new CounterThread(counterB);

        sThreadA.start();
        sThreadB.start();
    }
}
