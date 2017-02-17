package com.apea.training.ecourse.labwork1.stones;

import com.apea.training.ecourse.labwork1.misc.GemstoneType;

public class Diamond extends Gemstone {

    protected Diamond(double weight, double transparency) {
        super(weight, transparency);
    }

    public static Diamond create(double weight, double transparency) {
        weightCheck(weight);
        transparencyCheck(transparency);
        return new Diamond(weight, transparency);
    }

    @Override
    public GemstoneType getType() {
        return GemstoneType.PRECIOUS;
    }

    @Override
    public double getCaratPrice() {
        return 15_000;
    }
}
