package com.builder;

public class BuilderPatternTest {

    public static void main(String[] args) {

        ComputerBuilder gamingBuilder =
                new GamingComputerBuilder();

        ComputerDirector director =
                new ComputerDirector(gamingBuilder);

        Computer gamingPC =
                director.buildComputer();

        System.out.println("Gaming PC:");
        System.out.println(gamingPC);

        System.out.println();

        ComputerBuilder officeBuilder =
                new OfficeComputerBuilder();

        director = new ComputerDirector(officeBuilder);

        Computer officePC =
                director.buildComputer();

        System.out.println("Office PC:");
        System.out.println(officePC);
    }
}