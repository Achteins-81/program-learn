package org.achteins81.app.demo;

import java.math.BigDecimal;

public class JavaMathDemo {
    public static void main(String[] args) {
//        decimalRoundTest();

        Integer a = 1230;
        Integer b = 1230;
        System.out.println(a.equals(b));
    }

    private static void decimalRoundTest() {
        double[] nums = {1.4, 1.5, 1.6, -1.4, -1.5, -1.6};
        for (double num : nums) {
            decimalRound(num);
        }
    }

    private static void decimalRound(double num) {
        System.out.println("Math.floor(" + num + ")=" + Math.floor(num));
        System.out.println("Math.round(" + num + ")=" + Math.round(num));
        System.out.println("Math.ceil(" + num + ")=" + Math.ceil(num));
    }

    private static void bigDecimalTest() {

        BigDecimal decimal0, decimal1, decimal2;
        decimal0 = decimal1 = decimal2 = BigDecimal.ZERO;
        System.out.println(decimal0);
        System.out.println(decimal1);
        System.out.println(decimal2);
        decimal1 = BigDecimal.ONE;
        System.out.println(decimal0);
        System.out.println(decimal1);
        System.out.println(decimal2);
        decimal2 = BigDecimal.valueOf(123);
        System.out.println(decimal0);
        System.out.println(decimal1);
        System.out.println(decimal2);
    }
}
