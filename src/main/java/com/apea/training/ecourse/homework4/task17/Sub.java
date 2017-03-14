package com.apea.training.ecourse.homework4.task17;

public class Sub extends BinaryOperation  {

    protected Sub(Operation left, Operation right) {
        super(left, right);
    }

    @Override
    public double execute() {
        return left.execute() - right.execute();
    }
}
