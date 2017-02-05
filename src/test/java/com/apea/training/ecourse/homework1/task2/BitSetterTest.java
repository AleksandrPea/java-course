package com.apea.training.ecourse.homework1.task2;

import junit.framework.Assert;
import org.junit.Test;

public class BitSetterTest {

    /** Setting bits in right positions */
    @Test
    public void setBitTest() {
        Assert.assertEquals(BitSetter.setBit(0xFE, 0), 0xFF);
        Assert.assertEquals(BitSetter.setBit(0xA8, 1), 0xAA);
        Assert.assertEquals(BitSetter.setBit(0x7E, 7), 0xFE);
    }

    /** Clearing bits in right positions */
    @Test
    public void clearBitTest() {
        Assert.assertEquals(BitSetter.clearBit(0xFF, 0), 0xFE);
        Assert.assertEquals(BitSetter.clearBit(0xAA, 1), 0xA8);
        Assert.assertEquals(BitSetter.clearBit(0xFE, 7), 0x7E);
    }


    /** Setting bit at negative position */
    @Test(expected = IllegalArgumentException.class)
    public void setNegBitTest() {
        BitSetter.setBit(0xFF, -3);

    }

    /** Setting bit at big position */
    @Test(expected = IllegalArgumentException.class)
    public void setBigBitTest() {
        BitSetter.setBit(0xFF, 100);
    }

    /** Clearing bit at negative position */
    @Test(expected = IllegalArgumentException.class)
    public void clearNegBitTest() {
        BitSetter.clearBit(0xFF, -3);

    }

    /** Clearing bit at big position */
    @Test(expected = IllegalArgumentException.class)
    public void clearBigBitTest() {
        BitSetter.clearBit(0xFF, 100);
    }
}
