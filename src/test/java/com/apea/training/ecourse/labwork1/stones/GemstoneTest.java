package com.apea.training.ecourse.labwork1.stones;

import org.junit.Test;

public class GemstoneTest {

    @Test(expected = IllegalArgumentException.class)
    public void weightCheckTest() {
        Gemstone.weightCheck(-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void transparencyCheckNegTest() {
        Gemstone.transparencyCheck(-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void transparencyCheckBigTest() {
        Gemstone.transparencyCheck(1.1);
    }
}
