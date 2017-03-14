package com.apea.training.ecourse.homework4.task17;

public abstract class BinaryOperation implements Operation {

    protected Operation left;
    protected Operation right;

    protected BinaryOperation(Operation left, Operation right) {
        this.left = left;
        this.right = right;
    }
}
