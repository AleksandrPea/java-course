package com.apea.training.ecourse.homework4.task21;

public class UnderMagicFlyingStrategy implements MovingStrategy {

    private static UnderMagicFlyingStrategy instance = new UnderMagicFlyingStrategy();

    private UnderMagicFlyingStrategy() {}

    public static UnderMagicFlyingStrategy getInstance() { return instance;}


    @Override
    public void move() {
        System.out.print("fly for a while");
    }
}
