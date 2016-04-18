package com.ivanmagda;

/**
 * Signaling via Shared Objects.
 * <p>
 * <p>
 * A simple way for threads to send signals to each other is by setting the signal values in
 * some shared object variable. Thread A may set the boolean member variable hasDataToProcess to
 * true from inside a synchronized block, and thread B may read the hasDataToProcess member
 * variable, also inside a synchronized block. Here is a simple example of an object that can
 * hold such a signal, and provide methods to set and check it.
 * <p>
 * Note:
 * Thread A and B must have a reference to a shared MySignal instance for the signaling to work.
 * If thread A and B has references to different MySignal instance, they will not detect each
 * others signals. The data to be processed can be located in a shared buffer separate from the
 * MySignal instance.
 */

public class MySignal {

    protected boolean hasDataToProcess = false;

    public synchronized boolean isHasDataToProcess() {
        return hasDataToProcess;
    }

    public synchronized void setHasDataToProcess(boolean hasDataToProcess) {
        this.hasDataToProcess = hasDataToProcess;
    }

}
