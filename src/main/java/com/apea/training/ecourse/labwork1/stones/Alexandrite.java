package com.apea.training.ecourse.labwork1.stones;

public class Alexandrite extends Chrysoberyl {

    protected Alexandrite(double weight, double transparency) {
        super(weight, transparency);
    }

    @Override
    public double getCaratPrice() {
        return 12_000;
    }

    public static Alexandrite create(double weight, double transparency) {
        weightCheck(weight);
        transparencyCheck(transparency);
        return new Alexandrite(weight, transparency);
    }
}
