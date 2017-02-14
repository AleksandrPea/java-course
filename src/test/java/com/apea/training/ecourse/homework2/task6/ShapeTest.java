package com.apea.training.ecourse.homework2.task6;

import junit.framework.Assert;
import org.junit.Test;

public class ShapeTest {

    private Ring ring = Ring.create(15);
    private Parallelogram parallelogram = Parallelogram.create(12, 4);
    private Trapezium trapezium = Trapezium.create(4, 12, 18);
    private Triangle triangle = Triangle.create(10, 12);

    /** ring + parrallelogram */
    @Test
    public void addParRingTest() {
        Assert.assertEquals(ring.add(parallelogram),754.858, 0.001);
    }

    /** trapezium + triangle */
    @Test
    public void addTrapTriTest() {
        Assert.assertEquals(trapezium.add(triangle),120., 0.00001);
    }

    /** parrallelogram + triangle */
    @Test
    public void addParTriTest() {
        Assert.assertEquals(parallelogram.add(triangle),108., 0.00001);
    }

    /** triangle + ring */
    @Test
    public void addTriRingTest() {
        Assert.assertEquals(triangle.add(ring),766.858, 0.001);
    }

    /** trapezium + trapezium */
    @Test
    public void addTrapTrapTest() {
        Assert.assertEquals(trapezium.add(trapezium),120., 0.00001);
    }
}
