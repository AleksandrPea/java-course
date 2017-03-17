package com.apea.training.ecourse.homework4.task21;

public class WalkingStrategy implements MovingStrategy {
    private static WalkingStrategy instance = new WalkingStrategy();

    private WalkingStrategy() {}

    public static WalkingStrategy getInstance() { return instance;}
    @Override
    public void move() {
        System.out.print("walk");
    }
}
