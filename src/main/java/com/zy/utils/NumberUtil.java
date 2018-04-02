package com.zy.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtil {

    public static int SCALE = 16;

    public static double doubleAdd(double... dd) {
        BigDecimal result = BigDecimal.ZERO;
        for (Double n : dd) {
            if (n == null){
                n = 0D;
            }
            result = result.add(new BigDecimal("" + n));
        }

        return result.doubleValue();
    }

    public static double doubleMultiply(double d1, double d2, int scale) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.multiply(bd2).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }

    public static double doubleMultiply(double d1, double d2) {
        return doubleMultiply(d1, d2, SCALE);
    }
}
