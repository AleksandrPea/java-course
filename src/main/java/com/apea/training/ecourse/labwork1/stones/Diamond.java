package com.apea.training.ecourse.labwork1.stones;

import com.apea.training.ecourse.labwork1.misc.GemstoneType;
import com.apea.training.ecourse.labwork1.misc.GemstoneValue;
import com.apea.training.ecourse.labwork1.trading.Rialto;

public class Diamond extends Gemstone {

    protected Diamond(double weight, double transparency) {
        super(weight, transparency);
    }

    @Override
    public GemstoneValue getType() {
        return GemstoneValue.PRECIOUS;
    }

    @Override
    public double getCaratPrice() {
        return Rialto.getInstance().getCaratPrice(GemstoneType.DIAMOND);
    }

}
