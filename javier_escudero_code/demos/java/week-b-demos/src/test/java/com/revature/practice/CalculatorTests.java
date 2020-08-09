package com.revature.practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTests {

    private Calculator sut; // SUT = System Under Test

    @Before
    public void setUp() {
        sut = new Calculator();
    }

    @After
    public void tearDown() {
        sut = null;
    }

    @Test
    public void multiplyThreeAndFiveIsFifteen() {
        double expectedResult = 15;
        double actualResult = sut.multiply(3, 5);
        assertEquals("3 times 5 is 15", expectedResult, actualResult, .001);
    }

    @Test
    public void multiplyFiveAndThreeIsFifteen() {
        double expectedResult = 15;
        double actualResult = sut.multiply(5, 3);
        assertEquals("5 times 3 is 15", expectedResult, actualResult, .001);
    }

    @Test
    public void multipleZeroAndFifteenIsZero() {
        double expectedResult = 0;
        double actualResult = sut.multiply(0, 15);
        assertEquals("0 times 15 is 0", expectedResult, actualResult, 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZeroThrowsException() {
        sut.divide(10, 0);
    }

}
