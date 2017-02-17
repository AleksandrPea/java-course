package com.apea.training.ecourse.labwork1.stones;

import com.apea.training.ecourse.labwork1.misc.GemstoneType;

public class Benitoite extends Gemstone {

    protected Benitoite(double weight, double transparency) {
        super(weight, transparency);
    }

    public static Benitoite create(double weight, double transparency) {
        weightCheck(weight);
        transparencyCheck(transparency);
        return new Benitoite(weight, transparency);
    }

    @Override
    public GemstoneType getType() {
        return GemstoneType.SEMI_PRECIOUS;
    }

    @Override
    public double getCaratPrice() {
        return 4_000;
    }
}
