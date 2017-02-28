package com.apea.training.ecourse.labwork1.stones;

import com.apea.training.ecourse.labwork1.misc.GemstoneType;

public class GemstoneFactory {

    private static GemstoneFactory instance = new GemstoneFactory();

    private GemstoneFactory() {}

    public static GemstoneFactory getInstance() {return instance;}

    public Gemstone makeGemstone(double weight, double transparency, GemstoneType type) {
        Gemstone.weightCheck(weight);
        Gemstone.transparencyCheck(transparency);
        switch(type) {
            case ALEXANDRITE: return new Alexandrite(weight, transparency);
            case BENITOITE: return new Benitoite(weight, transparency);
            case CHRYSOBERYL: return new Chrysoberyl(weight, transparency);
            case DIAMOND: return new Diamond(weight, transparency);
            case RED_DIAMOND: return new RedDiamond(weight, transparency);
            case RUBY: return new Ruby(weight, transparency);
            default: return null;
        }
    }
}
