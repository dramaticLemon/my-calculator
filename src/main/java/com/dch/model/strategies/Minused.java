package com.dch.model.strategies;

public class Minused implements CalculateStrategies{
    
    @Override
    public double execute(int x, int y) {
        return x - y;
    }
}
