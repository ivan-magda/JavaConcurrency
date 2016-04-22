package com.ivanmagda;

public class InterferenceThread extends Thread {

    private final InterferenceExample checker;
    private static int counter;

    public InterferenceThread(InterferenceExample checker) {
        this.checker = checker;
    }

    @Override
    public void run() {
        while (!checker.stop()) {
            increment();
        }
    }

    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

}
