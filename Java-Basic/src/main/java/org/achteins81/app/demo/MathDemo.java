package org.achteins81.app.demo;

import org.achteins81.app.base.util.MathUtils;

/**
 * 数学demo
 *
 * @author Achteins-81
 * @since 2023-02-27
 */
public class MathDemo {
    public static void main(String[] args) {
        System.out.println(MathUtils.getGreatestCommonDivisor(10, 12));
        System.out.println(MathUtils.getGreatestCommonDivisorWithRecursion(10, 12));
        System.out.println(MathUtils.getLeastCommonMultiple(10, 12));
    }
}
