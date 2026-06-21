package com.builder;

public class GamingComputerBuilder extends ComputerBuilder {

    @Override
    public void buildCPU() {
        computer.setCPU("Intel Core i9");
    }

    @Override
    public void buildRAM() {
        computer.setRAM("32GB");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("1TB SSD");
    }
}