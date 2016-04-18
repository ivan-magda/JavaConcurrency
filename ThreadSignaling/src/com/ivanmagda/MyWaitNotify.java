package com.ivanmagda;

/**
 * wait(), notify() and notifyAll()
 * <p>
 * <p>
 * Java has a builtin wait mechanism that enable threads to become inactive while waiting for
 * signals. The class java.lang.Object defines three methods, wait(), notify(), and notifyAll(),
 * to facilitate this.
 * <p>
 * A thread that calls wait() on any object becomes inactive until another thread calls notify()
 * on that object. In order to call either wait() or notify the calling thread must first obtain
 * the lock on that object. In other words, the calling thread must call wait() or notify() from
 * inside a synchronized block. Here is a modified version of MySignal called MyWaitNotify that
 * uses wait() and notify().
 */

public class MyWaitNotify {

    MonitorObject monitorObject = new MonitorObject();

    public void doWait() {
        synchronized (monitorObject) {
            try {
                monitorObject.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void doNotify() {
        synchronized (monitorObject) {
            monitorObject.notify();
        }
    }

}
