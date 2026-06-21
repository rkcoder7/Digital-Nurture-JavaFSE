package com.cognizant.junit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SubtractTest {

    @Test
    public void testSubtract() {
        Calculator calc = new Calculator();
        assertEquals(10, calc.subtract(20, 10));
    }
}