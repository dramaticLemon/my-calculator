package com.dch.controller;

import com.dch.model.ExpressionParser;
import com.dch.view.ConsoleView;

public class CalculationController {
    private final ExpressionParser model;
    private final ConsoleView view;

    public CalculationController(ExpressionParser model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        try {
            String expression = view.getUserInput("Enter an arithmetic expression: ");
            double result = model.parseAndCalculate(expression);
            view.displayResult(result);
        } catch (IllegalArgumentException e) {
            view.displayError(e.getMessage());
        } finally {
            view.closeScanner();
        }
    }

    
}
