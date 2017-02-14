package com.apea.training.ecourse.homework2.task6;

import junit.framework.Assert;
import org.junit.Test;

public class TrapeziumTest {

    @Test(expected = IllegalArgumentException.class)
    public void exceptionCreateTest() {
        Trapezium trapezium = Trapezium.create(12, -7, 13);
    }

    @Test
    public void areaTest() {
        Trapezium trapezium = Trapezium.create(12, 7, 13);
        Assert.assertEquals(trapezium.area(), 120., 0.00001);
    }
}
