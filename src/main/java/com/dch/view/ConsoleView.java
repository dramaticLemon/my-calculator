package com.dch.view;

import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public void displayMessage(String message) {
        System.out.println(message);
    }
    
    public void displayResult(double result) {
        System.out.println("result is: " + result);
    }

    public String getUserInput(String prompt) {
        displayMessage(prompt);
        return scanner.nextLine();
    }
    
    public void displayError(String errorMessage) {
        System.err.println("Error: " + errorMessage);
    }
    
    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
