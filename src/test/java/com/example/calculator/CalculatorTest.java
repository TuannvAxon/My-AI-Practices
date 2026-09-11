package com.example.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void shouldDividePositiveNumbers() {
        assertEquals(5.0, calculator.divide(10.0, 2.0), 0.000001);
    }

    @Test
    void shouldDivideNegativeByPositive() {
        assertEquals(-5.0, calculator.divide(-10.0, 2.0), 0.000001);
    }

    @Test
    void shouldDivideTwoNegativeNumbers() {
        assertEquals(5.0, calculator.divide(-10.0, -2.0), 0.000001);
    }

    @Test
    void shouldReturnDecimalResult() {
        assertEquals(2.5, calculator.divide(5.0, 2.0), 0.000001);
    }

    @Test
    void shouldReturnZeroWhenDividendIsZero() {
        assertEquals(0.0, calculator.divide(0.0, 10.0), 0.000001);
    }

    @Test
    void shouldRejectDivisionByZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(10.0, 0.0));

        assertEquals("Divisor must not be zero", exception.getMessage());
    }
}
