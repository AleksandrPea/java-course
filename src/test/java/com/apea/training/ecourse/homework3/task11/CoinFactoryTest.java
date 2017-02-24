package com.apea.training.ecourse.homework3.task11;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CoinFactoryTest {

    private CoinFactory factory;

    @Before
    public void refreshFactory() {
        factory = CoinFactory.resetInstance(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionCreateCoinTest() {
        factory.createCoin(-3);
    }

    @Test(expected = TooManyCurrentCreatedObjectsException.class)
    public void exceptionSetCreatedMaxTest() {
        Coin c = factory.createCoin(2);
        factory.setCreatedMax(0);
    }

    @Test
    public void setCreatedMaxTest() {
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 1; i <= factory.getCreatedMax(); i++) {
            coins.add(factory.createCoin(i));
        }
        factory.setCreatedMax(factory.getCreatedMax() + 5);
        for (int i = 1; i <= 6; i++) {
            coins.add(factory.createCoin(i));
        }
        Assert.assertNull(coins.get(coins.size()-1));
    }


    @Test
    public void getCreatedCurrentEqZeroTest() {
        for (int i = 1; i <= factory.getCreatedMax(); i++) {
            factory.createCoin(i);
        }
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.gc();
        Assert.assertEquals(factory.getCreatedCurrent(), 0);
    }

    /**
     * Creating 3 coins and placing in list. Removing 1 coin.
     * Asserts:
     * 1) createdCurrent == 3 before removing.
     * 2) createdCurrent == 2 after removing and calling GC.
     */
    @Test
    public void getCreatedCurrentTest() {
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 1; i <= factory.getCreatedMax(); i++) {
            coins.add(factory.createCoin(i));
        }
        Assert.assertEquals(factory.getCreatedCurrent(), 3);
        coins.remove(0);
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.gc();
        Assert.assertEquals(factory.getCreatedCurrent(), 2);
    }

}
