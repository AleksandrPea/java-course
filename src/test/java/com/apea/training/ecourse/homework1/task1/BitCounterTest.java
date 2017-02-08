package com.apea.training.ecourse.homework1.task1;

import junit.framework.Assert;
import org.junit.Test;

public class BitCounterTest {

    @Test
    public void sizeInBitsOfByteTest() {
        Assert.assertEquals(BitCounter.sizeInBitsOfByte(), 8);
    }

    @Test
    public void sizeInBitsOfShortTest() {
        Assert.assertEquals(BitCounter.sizeInBitsOfShort(), 16);
    }

    @Test
    public void sizeInBitsOfIntTest() {
        Assert.assertEquals(BitCounter.sizeInBitsOfInt(), 32);
    }

    @Test
    public void sizeInBitsOfLongTest() {
        Assert.assertEquals(BitCounter.sizeInBitsOfLong(), 64);
    }
}
