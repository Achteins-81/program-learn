package org.achteins81.app.base.util;

/**
 * 数学工具方法类
 *
 * @author Achteins-81
 * @since 2023-02-27
 */
public class MathUtils {

    /**
     * 获取两个非负整数的最大公约数，采用辗转相除法/欧几里得算法(Euclidean Algorithm)
     *
     * @param a 第一个整数
     * @param b 第二个整数
     * @return a和b的最大公约数
     * @see <a href="https://baike.baidu.com/item/%E6%AC%A7%E5%87%A0%E9%87%8C%E5%BE%97%E7%AE%97%E6%B3%95/1647675">source</a>
     * and
     * <a href="https://blog.csdn.net/qq_20185737/article/details/107524078">source2</a>
     */
    public static int getGreatestCommonDivisor(int a, int b) {
        if (a < 0 || b < 0) {
            throw new RuntimeException("存在参数值小于0");
        }
        //根据大小取出两数
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        //取余数
        int mod = max % min;
        //最终返回的最大公约数
        int gcd;
        //如果余数不等于0，重新赋值取小数与余数的余数，直到余数为0，则小数为最大公约数
        while (mod != 0) {
            max = min;
            min = mod;
            mod = max % min;
        }
        gcd = min;
        return gcd;
    }

    /**
     * 另一种方式获取两个非负整数的最大公约数，采用辗转相除法/欧几里得算法(Euclidean Algorithm)及递归调用而非while循环
     *
     * @param a 第一个整数
     * @param b 第二个整数
     * @return a和b的最大公约数
     * @see <a href="https://baike.baidu.com/item/%E6%AC%A7%E5%87%A0%E9%87%8C%E5%BE%97%E7%AE%97%E6%B3%95/1647675">source</a>
     * and
     * <a href="https://blog.csdn.net/qq_20185737/article/details/107524078">source2</a>
     */
    public static int getGreatestCommonDivisorWithRecursion(int a, int b) {
        if (a < 0 || b < 0) {
            throw new RuntimeException("存在参数值小于0");
        }
        //处理参数，始终让a>=b
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        //取余
        int mod = a % b;
        //余数为0即a整除b时，b即为最大公约数
        if (mod == 0) {
            return b;
        }
        //如果余数不等于0，递归调用继续取小数与余数的最大公约数
        return getGreatestCommonDivisorWithRecursion(b, mod);
    }

    /**
     * 获取两个整数的最大公约数，先获取两数的最大公约数gcd(a,b)后再通过a*b/gcd(a,b)计算获取
     *
     * @param a 第一个整数
     * @param b 第二个整数
     * @return a和b的最小公倍数
     */
    public static int getLeastCommonMultiple(int a, int b) {
        if (a < 0 || b < 0) {
            throw new RuntimeException("存在参数值小于0");
        }
        return a * b / getGreatestCommonDivisor(a, b);
    }
}
