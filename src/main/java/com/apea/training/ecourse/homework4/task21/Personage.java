package com.apea.training.ecourse.homework4.task21;

public abstract class Personage {

    protected MovingStrategy movingStrategy;

    public abstract void moveAtDistance(int distance);

    public void enhance(){
        this.movingStrategy = UnderMagicFlyingStrategy.getInstance();
    }

}
