package com.cognizant.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {

        System.out.println("Setup Method Executed");

        calculator = new Calculator();
    }

    @After
    public void tearDown() {

        System.out.println("Teardown Method Executed");

        calculator = null;
    }

    @Test
    public void testAdd() {

        // Arrange
        int a = 10;
        int b = 20;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(30, result);
    }

    @Test
    public void testMultiply() {

        // Arrange
        int a = 5;
        int b = 4;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(20, result);
    }
}