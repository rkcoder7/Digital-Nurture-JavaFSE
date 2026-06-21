package com.cognizant.junit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AddTest {

    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(30, calc.add(10, 20));
    }
}