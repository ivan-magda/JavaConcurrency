package com.ivanmagda;

public class Main {

    public static void main(String[] args) {
        InterferenceExample interferenceExample = new InterferenceExample();

        try {
            interferenceExample.example();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
