package com.apea.training.ecourse.homework1.task2;

public class BitSetter {

    private BitSetter() {}

    /**
     * @param pos according to power of 2. So, leftmost bit has pos=0.
     */
    public static int setBit(int number, int pos) {
        if (pos < 0 || pos >= Integer.SIZE) {
            throw new IllegalArgumentException("Set right position from 0 to "+(Integer.SIZE-1));
        }
        int mask = 1;
        mask = mask << pos;
        return number | mask;
    }

    public static int clearBit(int number, int pos) {
        if (pos < 0 || pos >= Integer.SIZE) {
            throw new IllegalArgumentException("Set right position from 0 to "+(Integer.SIZE-1));
        }
        int mask = 1;
        mask = ~(mask << pos);
        return number & mask;
    }
}
