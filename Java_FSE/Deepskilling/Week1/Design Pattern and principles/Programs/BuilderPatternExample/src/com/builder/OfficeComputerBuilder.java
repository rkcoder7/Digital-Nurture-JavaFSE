package com.builder;

public class OfficeComputerBuilder extends ComputerBuilder {

    @Override
    public void buildCPU() {
        computer.setCPU("Intel Core i5");
    }

    @Override
    public void buildRAM() {
        computer.setRAM("8GB");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("512GB SSD");
    }
}