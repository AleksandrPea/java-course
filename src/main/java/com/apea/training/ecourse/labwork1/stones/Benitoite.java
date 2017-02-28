package com.apea.training.ecourse.labwork1.stones;

import com.apea.training.ecourse.labwork1.misc.GemstoneType;
import com.apea.training.ecourse.labwork1.misc.GemstoneValue;
import com.apea.training.ecourse.labwork1.trading.Rialto;

public class Benitoite extends Gemstone {

    protected Benitoite(double weight, double transparency) {
        super(weight, transparency);
    }

    @Override
    public GemstoneValue getType() {
        return GemstoneValue.SEMI_PRECIOUS;
    }

    @Override
    public double getCaratPrice() {
        return Rialto.getInstance().getCaratPrice(GemstoneType.BENITOITE);
    }
}
