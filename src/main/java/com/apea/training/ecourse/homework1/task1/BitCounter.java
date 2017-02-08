package com.apea.training.ecourse.homework1.task1;

public class BitCounter  {

    private BitCounter() {}

    public static int sizeInBitsOfByte() {
        byte number = -1;
        int result = 0;
        while (number != 0) {
            number <<= 1;
            result++;
        }
        return result;
    }

    public static int sizeInBitsOfShort() {
        short number = -1;
        int result = 0;
        while (number != 0) {
            number <<= 1;
            result++;
        }
        return result;
    }

    public static int sizeInBitsOfInt() {
        int number = -1;
        int result = 0;
        while (number != 0) {
            number <<= 1;
            result++;
        }
        return result;
    }

    public static int sizeInBitsOfLong() {
        long number = -1;
        int result = 0;
        while (number != 0) {
            number <<= 1;
            result++;
        }
        return result;
    }


}
