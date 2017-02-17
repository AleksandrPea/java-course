package com.apea.training.ecourse.labwork1.jewelry;

import com.apea.training.ecourse.labwork1.stones.Gemstone;

import java.util.Arrays;
import java.util.Comparator;

public class Jewels {

    private Jewels(){}

    /** ascending */
    public static Gemstone[] sortedByCrPrice(Jewel jewel) {
        Gemstone[] gemstones = jewel.getGemstones();
        Arrays.sort(gemstones, Comparator.comparingDouble(Gemstone::getCaratPrice));
        return gemstones;
    }

    public static Gemstone[] findWithTransparency(Jewel jewel, double trFrom, double trTo) {
        if (trFrom > trTo) {
            throw new IllegalArgumentException();
        }
        Gemstone[] gemstones = jewel.getGemstones();
        return Arrays.stream(gemstones)
                     .filter(gemstone -> gemstone.getTransparency() >= trFrom &&
                                         gemstone.getTransparency() <= trTo)
                     .toArray(Gemstone[]::new);
    }
}