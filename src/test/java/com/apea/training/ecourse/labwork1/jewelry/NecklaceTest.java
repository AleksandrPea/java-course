package com.apea.training.ecourse.labwork1.jewelry;

import com.apea.training.ecourse.labwork1.misc.GemstoneType;
import com.apea.training.ecourse.labwork1.stones.*;
import org.junit.Assert;
import org.junit.Test;

public class NecklaceTest {

    private GemstoneFactory factory = GemstoneFactory.getInstance();
    private Necklace necklace;

    public NecklaceTest() {
        this.necklace = Necklace.create(
                factory.makeGemstone(1, 0.7, GemstoneType.RED_DIAMOND),
                factory.makeGemstone(3, 0.7, GemstoneType.RUBY),
                factory.makeGemstone(4, 0.5, GemstoneType.BENITOITE),
                factory.makeGemstone(1, 0.85, GemstoneType.DIAMOND),
                factory.makeGemstone(1, 0.82, GemstoneType.DIAMOND),
                factory.makeGemstone(1, 0.82, GemstoneType.DIAMOND),
                factory.makeGemstone(6, 0.3, GemstoneType.BENITOITE),
                factory.makeGemstone(10, 0.4, GemstoneType.CHRYSOBERYL)
        );
    }

    @Test
    public void priceTest() {
        Assert.assertEquals(necklace.price(), 1117500., 0.1);
    }

    @Test
    public void weightTest() {
        Assert.assertEquals(necklace.weight(), 27., 1e-16);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createWithNullVarTest() {
        Necklace.create(factory.makeGemstone(10, 0.8, GemstoneType.DIAMOND), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createWithNullTest() {
        Necklace.create(null);
    }
}
