package com.apea.training.ecourse.homework1.task4;

public class Euclid {

    private Euclid() {}

    public static int gcd(int a, int b) {
        int absA = Math.abs(a);
        int absB = Math.abs(b);
        if (absA == 0) {
            return absB;
        }
        if (absB == 0) {
            return absA;
        }
        int shift = 0;
        while (((absA | absB) & 1) == 0) {
            absA >>= 1;
            absB >>= 1;
            shift++;
        }
        while ((absA & 1) == 0)
            absA >>= 1;
        do {
            while ((absB & 1) == 0)
                absB >>= 1;
            if (absA > absB) {
                int t = absB;
                absB = absA;
                absA = t;
            }
            absB = absB - absA;
        } while (absB != 0);
        return absA << shift;
    }
}
