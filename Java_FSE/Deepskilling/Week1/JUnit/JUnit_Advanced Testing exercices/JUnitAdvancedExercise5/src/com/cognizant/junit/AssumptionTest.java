package com.cognizant.junit;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;

public class AssumptionTest {

    @Test
    void testOnlyOnWindows() {

        assumeTrue(System.getProperty("os.name")
                .toLowerCase()
                .contains("windows"));

        System.out.println("Running on Windows");
    }
}