package com.apea.training.ecourse.homework2.task6;

public abstract class Shape {

    public abstract double area();

    public double add(Shape other) {
        return this.area() + other.area();
    }
}
