package com.apea.training.ecourse.homework1.task3;

import junit.framework.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class KaratsubaTest {

    /**
     * Simple multiplying: positive * positive
     */
    @Test
    public void multiplyTest() {
        Assert.assertEquals(Karatsuba.multiply(new BigInteger("53242"), new BigInteger("435345")),
                new BigInteger("23178638490"));
    }

    /**
     * 0 * 0
     */
    @Test
    public void multiplyZZTest() {
        Assert.assertEquals(Karatsuba.multiply(new BigInteger("0"), new BigInteger("0")),
                new BigInteger("0"));
    }

    /**
     * negative * positive
     */
    @Test
    public void multiplyNegPosTest() {
        Assert.assertEquals(Karatsuba.multiply(new BigInteger("-115657"), new BigInteger("254576")),
                new BigInteger("-29443496432"));
    }

    /**
     * negative * negative
     */
    @Test
    public void multiplyNegNegTest() {
        Assert.assertEquals(Karatsuba.multiply(new BigInteger("-115657"), new BigInteger("-254576")),
                new BigInteger("29443496432"));

    }

    @Test(expected = NullPointerException.class)
    public void multiplyNullTest() {
        Karatsuba.multiply(new BigInteger("-1"), null);
    }
}
