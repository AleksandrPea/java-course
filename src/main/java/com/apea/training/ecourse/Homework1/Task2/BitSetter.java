package com.apea.training.ecourse.Homework1.Task2;

public class BitSetter {

    /**
     * @param pos according to power of 2. So, leftmost bit has pos=0.
     */
    public static int setBit(int number, int pos) {
        int mask = 1;
        mask = mask << (pos-1);
        return number | mask;
    }

    public static int clearBit(int number, int pos) {
        int mask = 1;
        mask = ~(mask << (pos-1));
        return number & mask;
    }
}
