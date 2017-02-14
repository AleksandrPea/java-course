package com.apea.training.ecourse.homework2.task6;

import com.apea.training.ecourse.homework2.task6.Trapezium;
import junit.framework.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test(expected = IllegalArgumentException.class)
    public void exceptionCreateTest() {
        Triangle triangle = Triangle.create(-12, 10);
    }

    @Test
    public void areaTest() {
        Triangle triangle = Triangle.create(12, 10);
        Assert.assertEquals(triangle.area(), 60., 0.00001);
    }
}
