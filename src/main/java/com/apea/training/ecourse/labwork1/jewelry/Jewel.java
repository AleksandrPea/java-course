package com.apea.training.ecourse.labwork1.jewelry;

import com.apea.training.ecourse.labwork1.stones.Gemstone;

public interface Jewel {

    double price();

    double weight();

    int size();

    Gemstone[] getGemstones();
}
