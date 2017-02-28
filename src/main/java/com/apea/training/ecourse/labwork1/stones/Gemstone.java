package com.apea.training.ecourse.labwork1.stones;

import com.apea.training.ecourse.labwork1.misc.GemstoneValue;

public abstract class Gemstone {

    /** in carats */
    private double weight;

    /** from 0 to 1 */
    private double transparency;

    public Gemstone(double weight, double transparency){
        this.weight = weight;
        this.transparency = transparency;
    }

    public double totalPrice() {
        return getWeight()*getCaratPrice();
    }

    public abstract GemstoneValue getType();

    /** in $ */
    public abstract double getCaratPrice();

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        weightCheck(weight);
        this.weight = weight;
    }

    public double getTransparency() {
        return transparency;
    }

    protected void setTransparency(double transparency) {
        transparencyCheck(transparency);
        this.transparency = transparency;
    }

    protected static void weightCheck(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException(weight + " is <= 0.");
        }
    }

    protected static void transparencyCheck(double transparency) {
        if (transparency < 0 || transparency > 1) {
            throw new IllegalArgumentException("Transparency = "+transparency + " is not in 0..1");
        }
    }
}
