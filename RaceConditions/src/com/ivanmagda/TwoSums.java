package com.ivanmagda;

public class TwoSums {

    private int sum1 = 0;
    private int sum2 = 0;

    public int getSum1() {
        return sum1;
    }

    public int getSum2() {
        return sum2;
    }

    /**
     * Add param values to corresponding sum properties.
     *
     * Two threads can execute method at the same time. One thread inside the first synchronized block,
     * and another thread inside the second synchronized block.
     * This way threads will have to wait less for each other to execute the method.
     *
     * @param val1 - value to add to the first sum.
     * @param val2 - value to add to the second sum.
     */
    public void add(int val1, int val2){
        synchronized(this){
            this.sum1 += val1;
        }
        synchronized(this){
            this.sum2 += val2;
        }
    }

}
