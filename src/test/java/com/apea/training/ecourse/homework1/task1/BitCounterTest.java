package com.apea.training.ecourse.homework1.task1;

import junit.framework.Assert;
import org.junit.Test;

public class BitCounterTest {

    @Test
    public void sizeInBitsOfTest() {
        Assert.assertEquals(BitCounter.sizeInBitsOf(Numeric.BYTE), 8);
        Assert.assertEquals(BitCounter.sizeInBitsOf(Numeric.SHORT), 16);
        Assert.assertEquals(BitCounter.sizeInBitsOf(Numeric.INT), 32);
        Assert.assertEquals(BitCounter.sizeInBitsOf(Numeric.LONG), 64);
    }
}
