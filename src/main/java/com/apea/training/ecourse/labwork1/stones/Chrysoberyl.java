package com.apea.training.ecourse.labwork1.stones;

import com.apea.training.ecourse.labwork1.misc.GemstoneType;

public class Chrysoberyl extends Gemstone {

    protected Chrysoberyl(double weight, double transparency) {
        super(weight, transparency);
    }

    public static Chrysoberyl create(double weight, double transparency) {
        weightCheck(weight);
        transparencyCheck(transparency);
        return new Chrysoberyl(weight, transparency);
    }

    @Override
    public GemstoneType getType() {
        return GemstoneType.SEMI_PRECIOUS;
    }

    @Override
    public double getCaratPrice() {
        return 250;
    }
}
