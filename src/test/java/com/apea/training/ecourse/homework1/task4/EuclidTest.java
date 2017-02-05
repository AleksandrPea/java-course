package com.apea.training.ecourse.homework1.task4;

import junit.framework.Assert;
import org.junit.Test;

public class EuclidTest {

    /** Simple gcd test */
    @Test
    public void gcdTest() {
        Assert.assertEquals(Euclid.gcd(180, 33), 3);
    }

    /** Gcd with 0 argument */
    @Test
    public void gcdZeroTest() {
        Assert.assertEquals(Euclid.gcd(0, 0), 0);
        Assert.assertEquals(Euclid.gcd(5, 0), 5);
    }

    /** Gcd with 1 argument */
    @Test
    public void gcdOneTest() {
        Assert.assertEquals(Euclid.gcd(1, 5), 1);
    }

    /** Gcd with negative arguments */
    @Test
    public void gcdNegTest() {
        Assert.assertEquals(Euclid.gcd(-35, -50), 5);
        Assert.assertEquals(Euclid.gcd(-121, 33), 11);
    }
}
