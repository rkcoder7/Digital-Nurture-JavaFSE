package com.builder;

public abstract class ComputerBuilder {

    protected Computer computer;

    public Computer getComputer() {
        return computer;
    }

    public void createComputer() {
        computer = new Computer();
    }

    public abstract void buildCPU();

    public abstract void buildRAM();

    public abstract void buildStorage();
}