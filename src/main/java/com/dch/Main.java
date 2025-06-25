package com.dch;


import com.dch.controller.CalculationController;
import com.dch.model.ExpressionParser;
import com.dch.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        ConsoleView consoleView = new ConsoleView();
        CalculationController controller = new CalculationController(parser, consoleView);

        controller.start();
    }
}
