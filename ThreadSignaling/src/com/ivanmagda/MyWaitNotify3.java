package com.ivanmagda;

/**
 * Spurious Wakeups
 * <p>
 * <p>
 * For inexplicable reasons it is possible for threads to wake up even if notify() and
 * notifyAll() has not been called. This is known as spurious wakeups. Wakeups without any reason.
 * <p>
 * If a spurious wakeup occurs in the MyWaitNofity2 class's doWait() method the waiting thread
 * may continue processing without having received a proper signal to do so! This could cause
 * serious problems in your application.
 * <p>
 * To guard against spurious wakeups the signal member variable is checked inside a while loop
 * instead of inside an if-statement. Such a while loop is also called a spin lock. The thread
 * awakened spins around until the condition in the spin lock (while loop) becomes false. Here
 * is a modified version of MyWaitNotify2 that shows this.
 */
public class MyWaitNotify3 {

    MonitorObject monitorObject = new MonitorObject();
    boolean wasSignalled = false;

    public void doWait() {
        synchronized (monitorObject) {
            while (!wasSignalled) {
                try {
                    monitorObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            wasSignalled = false;
        }
    }

    public void doNotify() {
        synchronized (monitorObject) {
            wasSignalled = true;
            monitorObject.notify();
        }
    }

}
