package com.cognizant.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
    AddTest.class,
    SubtractTest.class
})

public class AllTests {
}