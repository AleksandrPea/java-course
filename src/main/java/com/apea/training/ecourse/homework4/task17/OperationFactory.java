package com.apea.training.ecourse.homework4.task17;

public class OperationFactory {

    private static OperationFactory instance = new OperationFactory();

    private OperationFactory() {}

    public static OperationFactory getInstance() {return instance;}

    public BinaryOperation createBinaryOperation(OperationType type, Operation left, Operation right) {
        if (type == null || left == null || right == null) {
            throw new IllegalArgumentException("No null params!");
        }
        switch (type) {
            case ADD: return new Add(left, right);
            case SUB: return new Sub(left, right);
            case MUL: return new Mul(left, right);
            case DIV: return new Div(left, right);
            default: throw new IllegalArgumentException("Operation is not binary");
        }
    }
}
