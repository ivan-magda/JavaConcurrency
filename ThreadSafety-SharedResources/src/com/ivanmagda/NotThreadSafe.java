package com.ivanmagda;

public class NotThreadSafe {
    StringBuilder stringBuilder = new StringBuilder();

    public void add(String text) {
        stringBuilder.append(text);
    }
}
