package com.apea.training.ecourse.homework1.task4;

public class Euclid {

    public static int gcd(int a, int b) {
        int result;
        int shift;
        if (a == 0) {
            result = b;
        } else if (b == 0) {
            result = a;
        } else {
            for (shift = 0; ((a | b) & 1) == 0; ++shift) {
                a >>= 1;
                b >>= 1;
            }
            while ((a & 1) == 0)
                a >>= 1;
            do {
                while ((b & 1) == 0)
                    b >>= 1;
                if (a > b) {
                    int t = b;
                    b = a;
                    a = t;
                }
                b = b - a;
            } while (b != 0);
            result = a << shift;
        }
        return result;
    }

    private Euclid() {}
}
