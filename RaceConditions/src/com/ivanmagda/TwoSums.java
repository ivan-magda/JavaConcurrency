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

    public void add(int val1, int val2){
        synchronized(this){
            this.sum1 += val1;
        }
        synchronized(this){
            this.sum2 += val2;
        }
    }

}
