package com.apea.training.ecourse.homework2.task7;

import org.junit.Test;

public class PuppyTest {

    private Puppy puppy = Puppy.bringToTheWorld("Barsik-young", "Sheep dog");

    @Test(expected = NullPointerException.class)
    public void exceptionCreateTest() {
        Puppy.bringToTheWorld("Ur", null);
    }
}
