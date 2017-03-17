package com.apea.training.ecourse.homework4.task21;

public class FlyingStrategy implements MovingStrategy {
    private static FlyingStrategy instance = new FlyingStrategy();

    private FlyingStrategy() {}

    public static FlyingStrategy getInstance() { return instance;}
    @Override
    public void move() {
        System.out.print("fly");
    }
}
