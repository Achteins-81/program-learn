package org.achteins81.app.random;

import java.security.SecureRandom;

/**
 * 随机数生成
 *
 * @author Achteins-81
 * @see <a href="https://blog.csdn.net/jjwwwww/article/details/82017508">Java中实现正态随机分布</a>
 * @since 2023-02-03
 */
public class RandomNumberGenerator {

    static SecureRandom innerSecureRandom = new SecureRandom();

    /**
     * 生成一个标准正态分布随机数，即平均值u=0，方差v=1
     *
     * @return 随机数
     */
    public static double getStandardNormalDistribution() {
        return getNormalDistribution(0, 1);
    }

    /**
     * 生成一个正态分布随机数，平均值u，方差v
     *
     * @param u 均值
     * @param v 方差
     * @return 随机数
     */
    public static double getNormalDistribution(double u, double v) {
        return Math.sqrt(v) * innerSecureRandom.nextGaussian() + u;
    }
}
