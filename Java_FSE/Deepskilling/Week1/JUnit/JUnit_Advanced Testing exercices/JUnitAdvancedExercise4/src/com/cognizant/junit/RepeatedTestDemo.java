package com.cognizant.junit;

import org.junit.jupiter.api.RepeatedTest;

public class RepeatedTestDemo {

    @RepeatedTest(5)
    void repeatTest() {
        System.out.println("Executing Test");
    }
}