package com.apea.training.ecourse.labwork1.stones;

import com.apea.training.ecourse.labwork1.misc.GemstoneType;
import com.apea.training.ecourse.labwork1.trading.Rialto;

public class RedDiamond extends Diamond {

    protected RedDiamond(double weight, double transparency) {
        super(weight, transparency);
    }

    @Override
    public double getCaratPrice() {
        return Rialto.getInstance().getCaratPrice(GemstoneType.RED_DIAMOND);
    }
}
