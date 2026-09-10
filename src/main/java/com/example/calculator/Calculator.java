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
    public int divide(int dividend, int divisor) {
        //if (divisor == 0) {
        //    throw new IllegalArgumentException("Divisor must not be zero");
        //}
        //return dividend / divisor;
		return dividend / 0;// chỗ này phải gây ra lỗi
    }
}
