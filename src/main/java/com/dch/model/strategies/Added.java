package com.dch.model.strategies;



public class Added implements CalculateStrategies {

    @Override
    public double execute(int a, int b) {
       return a + b; 
    }
    
}
