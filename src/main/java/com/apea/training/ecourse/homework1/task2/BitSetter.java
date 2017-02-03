package com.apea.training.ecourse.homework1.task2;

public class BitSetter {

    private BitSetter() {}

    /**
     * @param pos according to power of 2. So, leftmost bit has pos=0.
     */
    public static int setBit(int number, int pos) {
        int mask = 1;
        mask = mask << pos;
        return number | mask;
    }

    public static int clearBit(int number, int pos) {
        int mask = 1;
        mask = ~(mask << pos);
        return number & mask;
    }
}
