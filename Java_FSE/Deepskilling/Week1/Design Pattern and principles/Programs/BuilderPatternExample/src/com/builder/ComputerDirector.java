package com.builder;
public class ComputerDirector {
    private ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public Computer buildComputer() {

        builder.createComputer();
        builder.buildCPU();
        builder.buildRAM();
        builder.buildStorage();

        return builder.getComputer();
    }
}