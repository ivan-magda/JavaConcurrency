package com.ivanmagda;

class FunctionResult {

    private static final Function FUNCTION = Math::sin;
    private static final double A = 0;
    private static final double B = 2 * Math.PI;
    private static final double H = 0.0000001;

    private final int sectionCount;
    private double result;

    private final Object monitor;
    private int doneWorkers;

    FunctionResult(int sectionCount) {
        this.sectionCount = sectionCount;
        monitor = new Object();
    }

    void calculate() {
        double sectionSize = (B - A) / sectionCount;
        for (double i = 0; i < sectionCount; i++) {
            FunctionWorker functionWorker = new FunctionWorker(FUNCTION, this, i * sectionSize, (i + 1) * sectionSize, H);
            new Thread(functionWorker).start();
        }
        waitForResult();
    }

    private void waitForResult() {
        synchronized (monitor) {
            while (!isDone()) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    double getResult() {
        return result;
    }

    synchronized void appendValue(double value) {
        result += value;
    }

    synchronized void workerDone() {
        doneWorkers++;
        if (isDone()) {
            synchronized (monitor) {
                monitor.notify();
            }
        }
    }

    private boolean isDone() {
        return doneWorkers == sectionCount;
    }
}
