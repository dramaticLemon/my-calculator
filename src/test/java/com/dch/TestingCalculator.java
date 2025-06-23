package com.dch;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestingCalculator{

    @Test
    public void testingOperation() {
        String input = "+\n";
        Scanner scanner = new Scanner(input);
        char result = Calculator.getOperation(scanner);
        assertEquals('+', result);
    }
}