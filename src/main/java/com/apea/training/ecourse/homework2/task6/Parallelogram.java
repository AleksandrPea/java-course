package com.apea.training.ecourse.homework2.task6;

public class Parallelogram extends Shape {

    private double height;
    private double base;

    private Parallelogram(double height, double base) {
        this.height = height;
        this.base = base;
    }

    public static Parallelogram create(double height, double base) {
        if (height <= 0 || base <= 0) {
            throw new IllegalArgumentException("Height or base can't be <= 0.");
        }
        return new Parallelogram(height, base);
    }

    @Override
    public double area() {
        return height*base;
    }
}
