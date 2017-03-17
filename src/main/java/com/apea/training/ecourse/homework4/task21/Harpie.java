package com.apea.training.ecourse.homework4.task21;

public class Harpie extends Personage {

    public Harpie() {
        movingStrategy = FlyingStrategy.getInstance();
    }

    @Override
    public void moveAtDistance(int distance) {
        movingStrategy.move();
    }
}
