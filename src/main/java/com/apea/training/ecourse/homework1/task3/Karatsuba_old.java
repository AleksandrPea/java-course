package com.apea.training.ecourse.homework1.task3;

// not working

/**
 * @deprecated
 */
public class Karatsuba_old {

    public static long mul(int x, int y) {
        StringBuilder sbX = prepareBinary(x);
        StringBuilder sbY = prepareBinary(y);
        int n = Math.max(sbX.length(), sbY.length());
        if (n <= 8) {
            return x*y;
        } else {
            String sX = normalize(sbX, n);
            n = sX.length();
            String sY = normalize(sbY, n);
            int x_l = parseBinary(sX, 0, sX.length()/2);
            int x_r = parseBinary(sX,sX.length()/2, sX.length());
            int y_l =  parseBinary(sY,0, sY.length()/2);
            int y_r = parseBinary(sY,sY.length()/2, sY.length());
            long prod1 = mul(x_l, y_l);
            long prod2 = mul(x_r, y_r);
            long prod3 = mul(x_l + x_r, y_l + y_r);
            return (long)(Math.signum(x)*Math.signum(y))*
                    (prod1 << n  + (prod3-prod1-prod2) << (n/2) + prod2);
        }

    }

    private static int parseBinary(String number, int beginIndex, int endIndex) {
        if (endIndex == 0) {
            return 0;
        } else {
            return Integer.parseInt(number.substring(beginIndex,endIndex), 2);
        }
    }

    private static StringBuilder prepareBinary(int number) {
        StringBuilder result = new StringBuilder(Integer.toBinaryString(number));
        // deleting minus
        if (result.charAt(0) == 1) {
            result.replace(0, 1, "0");
        }
        return result;
    }

    private static String normalize(StringBuilder number, int n) {
        int delta = Math.abs(number.length() - n);
        // making even size
        if ((number.length()+delta) % 2 != 0) {
            delta++;
        }
        StringBuilder zeroes = new StringBuilder();
        while (delta != 0) {
            zeroes.append("0");
            delta--;
        }
        return zeroes.append(number).toString();
    }
}
