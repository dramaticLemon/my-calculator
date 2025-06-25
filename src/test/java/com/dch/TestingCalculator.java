package com.dch;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.dch.model.ExpressionParser;

class ExpressionParserTest {

    private ExpressionParser parser;

    // Этот метод будет выполняться перед каждым тестовым методом
    @BeforeEach
    void setUp() {
        parser = new ExpressionParser();
    }

    @Test
    @DisplayName("Должен корректно вычислять сложение")
    void shouldCalculateAdditionCorrectly() {
        assertEquals(4.0, parser.parseAndCalculate("2+2"));
        assertEquals(5.0, parser.parseAndCalculate("2 + 3"));
        assertEquals(10.0, parser.parseAndCalculate("7   +   3"));
    }

    @Test
    @DisplayName("Должен корректно вычислять вычитание")
    void shouldCalculateSubtractionCorrectly() {
        assertEquals(0.0, parser.parseAndCalculate("2-2"));
        assertEquals(2.0, parser.parseAndCalculate("5 - 3"));
        assertEquals(-1.0, parser.parseAndCalculate("3-4"));
    }

    @Test
    @DisplayName("Должен корректно вычислять умножение")
    void shouldCalculateMultiplicationCorrectly() {
        assertEquals(4.0, parser.parseAndCalculate("2*2"));
        assertEquals(15.0, parser.parseAndCalculate("5 * 3"));
        assertEquals(0.0, parser.parseAndCalculate("7*0"));
    }

    @Test
    @DisplayName("Должен корректно вычислять деление")
    void shouldCalculateDivisionCorrectly() {
        assertEquals(1.0, parser.parseAndCalculate("2/2"));
        assertEquals(2.5, parser.parseAndCalculate("5 / 2"));
        assertEquals(0.0, parser.parseAndCalculate("0/5"));
    }

    @Test
    @DisplayName("Должен выбрасывать исключение для деления на ноль")
    void shouldThrowExceptionForDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> parser.parseAndCalculate("5/0"));
          }


}