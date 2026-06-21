package com.cognizant.junit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MathOperationsTest {

    @Test
    public void testAdd() {

        MathOperations math = new MathOperations();

        int result = math.add(10, 20);

        assertEquals(30, result);
    }

    @Test
    public void testSubtract() {

        MathOperations math = new MathOperations();

        int result = math.subtract(20, 10);

        assertEquals(10, result);
    }

    @Test
    public void testMultiply() {

        MathOperations math = new MathOperations();

        int result = math.multiply(5, 4);

        assertEquals(20, result);
    }
}