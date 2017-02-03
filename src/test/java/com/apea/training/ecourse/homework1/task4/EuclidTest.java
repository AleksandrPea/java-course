package com.apea.training.ecourse.homework1.task4;

import junit.framework.Assert;
import org.junit.Test;

public class EuclidTest {

    @Test
    public void gcdTest() {
        Assert.assertEquals(Euclid.gcd(0, 0), 0);
        Assert.assertEquals(Euclid.gcd(0, 5), 5);
        Assert.assertEquals(Euclid.gcd(1, 5), 1);
        Assert.assertEquals(Euclid.gcd(180, 33), 3);
    }
}
