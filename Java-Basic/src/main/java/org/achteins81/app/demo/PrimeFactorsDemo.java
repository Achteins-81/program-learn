package org.achteins81.app.demo;

import org.achteins81.app.base.util.MathUtils;

import java.util.List;

/**
 * 分解质因数demo
 *
 * @author Achteins-81
 * @since 2023-03-17
 */
public class PrimeFactorsDemo {
    public static void main(String[] args) {
        int num = 65536 - 1;
        List<Integer> factors = MathUtils.getPrimeFactors(num);
        System.out.printf("质因数：%s，质因数相乘结果检查：%d%n", factors, MathUtils.checkPrimeFactors(num, factors));

        int num1 = -87;
        List<Integer> factors1 = MathUtils.getPrimeFactors(num1);
        System.out.printf("质因数：%s，质因数相乘结果检查：%d%n", factors, MathUtils.checkPrimeFactors(num1, factors1));
    }
}
