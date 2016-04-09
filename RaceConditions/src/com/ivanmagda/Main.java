package com.ivanmagda;

public class Main {

    public static void main(String[] args) {

        /**
         * 1. Race Conditions in Critical Sections.
         */

        Counter counter = new Counter();

        /*
         * counter.count = 0;
         *
         * A:  Reads this.count into a register (0)
         * B:  Reads this.count into a register (0)
         * B:  Adds value 2 to register
         * B:  Writes register value (2) back to memory. this.count now equals 2
         * A:  Adds value 3 to register
         * A:  Writes register value (3) back to memory. this.count now equals 3
         */

        new Thread(() -> {
            counter.add(2);
            System.out.println("Count threadA: " + counter.count);
        }).start();


        new Thread(() -> {
            counter.add(3);
            System.out.println("Count threadB: " + counter.count);
        }).start();

        /**
         * 2. Preventing race conditions using synchronized blocks.
         */

        TwoSums twoSums = new TwoSums();

        new Thread(() -> {
            twoSums.add(10, 5);
            System.out.println("Sum1: " + twoSums.getSum1());
            System.out.println("Sum2: " + twoSums.getSum2());
        }).start();

        new Thread(() -> {
            twoSums.add(1, 2);
            System.out.println("Sum1: " + twoSums.getSum1());
            System.out.println("Sum2: " + twoSums.getSum2());
        }).start();
    }

}
