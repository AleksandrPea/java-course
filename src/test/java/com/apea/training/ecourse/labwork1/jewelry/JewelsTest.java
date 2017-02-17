package com.apea.training.ecourse.labwork1.jewelry;

import com.apea.training.ecourse.labwork1.stones.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class JewelsTest {

    private Jewel jewel;
    private RedDiamond redDiamond = RedDiamond.create(1, 0.7);
    private Ruby ruby = Ruby.create(3, 0.65);
    private Benitoite benitoite1 = Benitoite.create(4, 0.5);
    private Diamond diamond1 = Diamond.create(1, 0.85);
    private Diamond diamond2 = Diamond.create(1, 0.82);
    private Diamond diamond3 = Diamond.create(1, 0.82);
    private Benitoite benitoite2 = Benitoite.create(6, 0.3);
    private Chrysoberyl chrysoberyl = Chrysoberyl.create(10, 0.4);


    public JewelsTest() {
        this.jewel = Necklace.create(
            redDiamond, ruby, benitoite1, diamond1, diamond2, diamond3, benitoite2, chrysoberyl
        );
    }

    @Test
    public void sortedByCrPriceTest() {
        Assert.assertArrayEquals(Jewels.sortedByCrPrice(jewel),
                new Gemstone[]{chrysoberyl, benitoite1, benitoite2, ruby, diamond1, diamond2, diamond3, redDiamond});
    }

    @Test(expected = NullPointerException.class)
    public void sortedByWithNullTest() {
        Jewels.sortedByCrPrice(null);
    }

    @Test
    public void findWithTransparencyTest() {
        List<Gemstone> gemstoneList = Arrays.asList(
                Jewels.findWithTransparency(jewel, 0.7, 0.85)
        );
        Assert.assertTrue(gemstoneList.containsAll(Arrays.asList(diamond1, diamond2, diamond3, redDiamond)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void findWithWrongIndciesTest() {
        Jewels.findWithTransparency(jewel, 1.0, 0.5);
    }

    @Test(expected = NullPointerException.class)
    public void findWithNullTest() {
        Jewels.findWithTransparency(null, 0., 0.2);
    }
}
