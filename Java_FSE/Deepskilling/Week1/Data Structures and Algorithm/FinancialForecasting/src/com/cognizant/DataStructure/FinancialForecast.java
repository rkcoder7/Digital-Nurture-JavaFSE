package com.cognizant.DataStructure;

public class FinancialForecast {

    public static double predictValue(
            double currentValue,
            double growthRate,
            int years) {

        if(years == 0)
            return currentValue;

        return predictValue(
                currentValue *
                        (1 + growthRate),
                growthRate,
                years - 1);
    }

    public static void main(String[] args) {

        double futureValue =
                predictValue(
                        10000,
                        0.10,
                        5);

        System.out.println(
                "Future Value = "
                        + futureValue);
    }
}