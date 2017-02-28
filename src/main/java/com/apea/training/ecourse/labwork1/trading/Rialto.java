package com.apea.training.ecourse.labwork1.trading;

import com.apea.training.ecourse.labwork1.misc.GemstoneType;

import java.util.HashMap;
import java.util.Map;

import static com.apea.training.ecourse.labwork1.misc.GemstoneType.*;

public class Rialto {

    private Map<GemstoneType, Double> caratPrices = new HashMap<>();
    private static Rialto instance = new Rialto();

    private Rialto() {
        fetchPrices();
    }

    public static Rialto getInstance() { return instance;}

    // dummy method
    public void fetchPrices() {
        caratPrices.put(ALEXANDRITE, 12_000.);
        caratPrices.put(BENITOITE, 4_000.);
        caratPrices.put(CHRYSOBERYL, 250.);
        caratPrices.put(DIAMOND, 15_000.);
        caratPrices.put(RED_DIAMOND, 1_000_000.);
        caratPrices.put(RUBY, 10_000.);
    }

    public double getCaratPrice(GemstoneType type) {
        return caratPrices.get(type);
    }
}
