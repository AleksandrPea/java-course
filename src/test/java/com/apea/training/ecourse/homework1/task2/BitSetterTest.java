package com.apea.training.ecourse.homework1.task2;

import junit.framework.Assert;
import org.junit.Test;

public class BitSetterTest {

    @Test
    public void setBitTest() {
        Assert.assertEquals(BitSetter.setBit(0xFE, 0), 0xFF);
        Assert.assertEquals(BitSetter.setBit(0xA8, 1), 0xAA);
        Assert.assertEquals(BitSetter.setBit(0x7E, 7), 0xFE);
    }

    @Test
    public void clearBitTest() {
        Assert.assertEquals(BitSetter.clearBit(0xFF, 0), 0xFE);
        Assert.assertEquals(BitSetter.clearBit(0xAA, 1), 0xA8);
        Assert.assertEquals(BitSetter.clearBit(0xFE, 7), 0x7E);
    }
}
