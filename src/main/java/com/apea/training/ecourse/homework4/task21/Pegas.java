package com.apea.training.ecourse.homework4.task21;

public class Pegas extends Personage {

    @Override
    public void moveAtDistance(int distance) {
        if (distance < 50) {
            movingStrategy = WalkingStrategy.getInstance();
        } else {
            movingStrategy = FlyingStrategy.getInstance();
        }
        movingStrategy.move();
    }
}
