package com.apea.training.ecourse.labwork1.stones;

public class RedDiamond extends Diamond {

    private RedDiamond(double weight, double transparency) {
        super(weight, transparency);
    }

    public static RedDiamond create(double weight, double transparency) {
        weightCheck(weight);
        transparencyCheck(transparency);
        return new RedDiamond(weight, transparency);
    }

    @Override
    public double getCaratPrice() {
        return 1_000_000;
    }
}
