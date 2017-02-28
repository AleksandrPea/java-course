package com.apea.training.ecourse.labwork1.jewelry;

import com.apea.training.ecourse.labwork1.stones.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.apea.training.ecourse.labwork1.misc.GemstoneType.*;

public class JewelsTest {
    private GemstoneFactory factory = GemstoneFactory.getInstance();
    private Jewel jewel;
    private RedDiamond redDiamond = (RedDiamond) factory.makeGemstone(1, 0.7, RED_DIAMOND);
    private Ruby ruby = (Ruby) factory.makeGemstone(3, 0.65, RUBY);
    private Benitoite benitoite1 = (Benitoite) factory.makeGemstone(4, 0.5, BENITOITE);
    private Diamond diamond1 = (Diamond) factory.makeGemstone(1, 0.85, DIAMOND);
    private Diamond diamond2 = (Diamond) factory.makeGemstone(1, 0.82, DIAMOND);
    private Diamond diamond3 = (Diamond) factory.makeGemstone(1, 0.82, DIAMOND);
    private Benitoite benitoite2 = (Benitoite) factory.makeGemstone(6, 0.3, BENITOITE);
    private Chrysoberyl chrysoberyl = (Chrysoberyl) factory.makeGemstone(10, 0.4, CHRYSOBERYL);


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
