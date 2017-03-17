package com.apea.training.ecourse.homework4.task17;

public class Operand implements Operation {

    private double value;

    public Operand(double value) {
        this.value = value;
    }

    @Override
    public double execute() {
        return value;
    }
}
