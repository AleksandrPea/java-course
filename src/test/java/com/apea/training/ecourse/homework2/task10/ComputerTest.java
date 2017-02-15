package com.apea.training.ecourse.homework2.task10;
import org.junit.Test;

public class ComputerTest {

    @Test(expected = NullPointerException.class)
    public void exceptionCreateTest() {
        Computer.createComputer(null, null, null);
    }
}
