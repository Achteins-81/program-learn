package org.achteins81.app.demo;

import org.achteins81.app.random.RandomNumberGenerator;

/**
 * 正态分布随机数生成demo
 *
 * @author Achteins-81
 * @since 2023-02-03
 */
public class NormalDistributionDemo {
    public static void main(String[] args) {
        int total = 1000;
        for (int i = 0; i < total; i++) {
            System.out.println(RandomNumberGenerator.getStandardNormalDistribution());
        }
    }
}
