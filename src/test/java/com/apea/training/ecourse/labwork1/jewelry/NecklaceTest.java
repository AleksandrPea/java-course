package com.apea.training.ecourse.labwork1.jewelry;

import com.apea.training.ecourse.labwork1.stones.*;
import org.junit.Assert;
import org.junit.Test;

public class NecklaceTest {

    private Necklace necklace;

    public NecklaceTest() {
        this.necklace = Necklace.create(
                RedDiamond.create(1, 0.7),
                Ruby.create(3, 0.7),
                Benitoite.create(4, 0.5),
                Diamond.create(1, 0.85),
                Diamond.create(1, 0.82),
                Diamond.create(1, 0.82),
                Benitoite.create(6, 0.3),
                Chrysoberyl.create(10, 0.4)
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
        Necklace.create(Diamond.create(10, 0.8), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createWithNullTest() {
        Necklace.create(null);
    }
}
