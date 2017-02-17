package com.apea.training.ecourse.labwork1.stones;

import com.apea.training.ecourse.labwork1.misc.GemstoneType;

public class Ruby extends Gemstone {

    protected Ruby(double weight, double transparency) {
        super(weight, transparency);
    }

    public static Ruby create(double weight, double transparency) {
        weightCheck(weight);
        transparencyCheck(transparency);
        return new Ruby(weight, transparency);
    }

    @Override
    public GemstoneType getType() {
        return GemstoneType.PRECIOUS;
    }

    @Override
    public double getCaratPrice() {
        return 10_000;
    }
}
