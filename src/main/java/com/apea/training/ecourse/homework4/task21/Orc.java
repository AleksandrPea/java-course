package com.apea.training.ecourse.homework4.task21;

public class Orc extends Personage {

    @Override
    public void moveAtDistance(int distance) {
        if (distance < 1000) {
            movingStrategy = WalkingStrategy.getInstance();
        } else {
            enhance();
        }
        movingStrategy.move();
    }
}
