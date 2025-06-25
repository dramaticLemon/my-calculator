package com.dch.model.strategies;

public class Divided implements CalculateStrategies{

    @Override
    public double execute(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division ve zero");
        }
        
        return (double) a / (double) b;
    }

}
