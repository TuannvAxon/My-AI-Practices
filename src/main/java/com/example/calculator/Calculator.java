package com.example.calculator;

/**
 * Basic calculator operations.
 */
public class Calculator {

    /**
     * Divides dividend by divisor.
     *
     * @throws IllegalArgumentException when divisor is zero
     */
    public double divide(double dividend, double divisor) {
        if (divisor == 0.0d) {
            throw new IllegalArgumentException("Divisor must not be zero");
        }
        //return dividend / divisor;
		return dividend / 0;// chỗ này phải gây ra lỗi
    }
}
