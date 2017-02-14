package com.apea.training.ecourse.homework2.task7;

import org.junit.Test;

import java.io.PrintStream;

public class DogTest {

    private Dog dog = Dog.bringToTheWorld("Barsik", "Sheep dog");

    @Test(expected = NullPointerException.class)
    public void exceptionCreateTest() {
        Dog dog = Dog.bringToTheWorld("Ur", null);
    }
}
