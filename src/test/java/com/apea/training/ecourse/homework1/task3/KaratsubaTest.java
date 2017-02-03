package com.apea.training.ecourse.homework1.task3;

import junit.framework.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class KaratsubaTest {

    @Test
    public void multiplyTest() {
        Assert.assertEquals(Karatsuba.multiply(new BigInteger("0"), new BigInteger("435345")),
                new BigInteger("0"));
        Assert.assertEquals(Karatsuba.multiply(new BigInteger("53242"), new BigInteger("435345")),
                new BigInteger("23178638490"));
    }
}
