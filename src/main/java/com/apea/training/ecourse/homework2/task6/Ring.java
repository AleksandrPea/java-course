package com.apea.training.ecourse.homework2.task6;

public class Ring extends Shape {

    private double r;

    private Ring(double r) {
        this.r = r;
    }

    public static Ring create(double r) {
        if (r <= 0) {
            throw new IllegalArgumentException("Radius can't be <= 0.");
        }
        return new Ring(r);
    }

    @Override
    public double area() {
        return Math.PI* Math.pow(r, 2);
    }
}
