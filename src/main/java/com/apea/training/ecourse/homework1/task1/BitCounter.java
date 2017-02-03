package com.apea.training.ecourse.homework1.task1;

public class BitCounter  {

    private BitCounter() {}

    /**
     * return sizeof(type) in bits or 0 if type
     * has not been recognized
     */
    public static int sizeInBitsOf(Numeric type) {
        long number;
        switch (type) {
            case BYTE:
                number = Byte.toUnsignedLong((byte) -1);
                break;
            case SHORT:
                number = Short.toUnsignedLong((short) -1);
                break;
            case INT:
                number = Integer.toUnsignedLong(-1);
                break;
            case LONG:
                number = -1L;
                break;
            default:
                number=0;
                break;
        }
        int result = 0;
        while (number != 0) {
            number = number >>> 1;
            result++;
        }
        return result;
    }
}
