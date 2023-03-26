package com.example.demojunit;

public class Calculator {
    public static int multiplier(int a, int b) throws RuntimeException {
        if (a > 1000) throw new RuntimeException("exception");
        return a * b;
    }

    public int sum(int a, int b) {
        return a + b;
    }

}
