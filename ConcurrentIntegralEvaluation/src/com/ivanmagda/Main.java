package com.ivanmagda;

public class Main {

    private static final int MAX_NUMBER_OF_THREADS = 10;

    public static void main(String[] args) {
        long[] executionTimes = new long[MAX_NUMBER_OF_THREADS];
        for (int i = 1; i <= MAX_NUMBER_OF_THREADS; i++) {
            long executionTime = executionTimeWithNumberOfThreads(i);
            executionTimes[i - 1] = executionTime;
        }

        int minIdx = findMinTimeIndex(executionTimes);
        System.out.println("\nBest number of threads for computing the function is: " + (minIdx + 1) + ".");
    }

    private static long executionTimeWithNumberOfThreads(int threadsCount) {
        assert threadsCount > 0;

        long startTime = System.nanoTime();

        FunctionResult result = new FunctionResult(threadsCount);
        result.calculate();

        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        System.out.println(threadsCount + ". Sum = " + result.getResult() + ". Execution time: " + (executionTime / 1000000000d));

        return executionTime;
    }

    private static int findMinTimeIndex(long[] times) {
        int minIdx = 0;
        for (int i = 1; i < times.length; i++) {
            if (times[minIdx] > times[i]) {
                minIdx = i;
            }
        }
        return minIdx;
    }

}
