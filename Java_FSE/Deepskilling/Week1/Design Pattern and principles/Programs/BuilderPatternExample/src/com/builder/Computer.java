package com.builder;

public class Computer {

    private String CPU;
    private String RAM;
    private String Storage;

    public void setCPU(String cPU) {
        CPU = cPU;
    }

    public void setRAM(String rAM) {
        RAM = rAM;
    }

    public void setStorage(String storage) {
        Storage = storage;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM +
               ", Storage=" + Storage + "]";
    }
}