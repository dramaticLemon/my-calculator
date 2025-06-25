package com.dch.model.strategies;

public class Multiplyed implements CalculateStrategies{

    @Override
    public double execute(int a, int b) {
        return a * b;
    }
    
}
