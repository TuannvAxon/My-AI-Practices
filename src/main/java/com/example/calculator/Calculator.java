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
      		return dividend / divisor;// chỗ này phải gây ra lỗi
    }
	
	
public int getDiscountPrice(int price) {
    if (price > 100) {
        return price;
    }

    return price - 20;
}// đua ra commnet
	
}
