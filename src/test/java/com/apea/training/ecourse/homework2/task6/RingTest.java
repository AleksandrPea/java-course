package com.apea.training.ecourse.homework2.task6;

import junit.framework.Assert;
import org.junit.Test;

public class RingTest {

    @Test(expected = IllegalArgumentException.class)
    public void exceptionCreateTest() {
        Ring ring = Ring.create(-10);
    }

    @Test
    public void areaTest() {
        Ring ring = Ring.create(12);
        Assert.assertEquals(ring.area(), 452.389, 0.001);
    }
}
