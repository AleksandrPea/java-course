package com.apea.training.ecourse.homework3.task11;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

public class CoinFactory {

    private static CoinFactory instance = new CoinFactory(3);

    private int createdMax;

    private ReferenceQueue<Coin> refQueue = new ReferenceQueue<>();
    private List<PhantomReference<Coin>> phantoms = new ArrayList<>();

    private int createdCurrent = 0;

    private CoinFactory(int createdMax) {this.createdMax = createdMax;}

    public static CoinFactory getInstance() {
        return instance;
    }

    public static CoinFactory resetInstance(int createdMax) {
        checkNoNegative(createdMax);
        instance = new CoinFactory(createdMax);
        return instance;
    }

    /** If number of created Coins is >= {@link #createdMax} then returns null */
    public Coin createCoin(int value) {
        checkNoNegative(value);
        if (getCreatedCurrent() >= createdMax) {
            return null;
        }
        Coin coin = new Coin(value);
        phantoms.add(new PhantomReference<>(coin, refQueue));
        createdCurrent++;
        return coin;
    }

    public int getCreatedCurrent() {
        refreshCurrentN();
        return createdCurrent;
    }

    public int getCreatedMax() {
        return createdMax;
    }

    public void setCreatedMax(int createdMax) {
        if (createdMax < getCreatedCurrent()) {
            throw new TooManyCurrentCreatedObjectsException(""+createdCurrent);
        }
        this.createdMax = createdMax;
    }

    private void refreshCurrentN() {
        Reference<? extends Coin> ref = refQueue.poll();
        while (ref != null) {
            createdCurrent--;
            ref = refQueue.poll();
        }
    }

    private static void checkNoNegative(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("negative value");
        }
    }
}
