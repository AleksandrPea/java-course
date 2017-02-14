package com.apea.training.ecourse.homework2.task6;

import junit.framework.Assert;
import org.junit.Test;

public class ParallelogramTest {

    @Test(expected = IllegalArgumentException.class)
    public void exceptionCreateTest() {
        Parallelogram parallelogram = Parallelogram.create(-10, -5);
    }

    @Test
    public void areaTest() {
        Parallelogram parallelogram = Parallelogram.create(20, 5);
        Assert.assertEquals(parallelogram.area(), 100., 0.00001);
    }
}
