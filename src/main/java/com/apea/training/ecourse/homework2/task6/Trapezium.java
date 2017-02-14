package com.apea.training.ecourse.homework2.task6;

public class Trapezium extends Shape {

    private double height;
    private double base1;
    private double base2;

    private Trapezium(double height, double base1, double base2) {
        this.height = height;
        this.base1 = base1;
        this.base2 = base2;
    }

    public static Trapezium create(double height, double base1, double base2) {
        if (height <= 0 || base1 <= 0 || base2 <= 0) {
            throw new IllegalArgumentException("Height or base can't be <= 0.");
        }
        return new Trapezium(height, base1, base2);
    }

    @Override
    public double area() {
        return height*(base1+base2)*0.5;
    }
}
