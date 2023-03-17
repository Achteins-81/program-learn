package org.achteins81.app.base.util;

import java.util.ArrayList;
import java.util.List;

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
     * @see <a href="https://baike.baidu.com/item/%E6%AC%A7%E5%87%A0%E9%87%8C%E5%BE%97%E7%AE%97%E6%B3%95/1647675">source1</a>
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
     * @see <a href="https://baike.baidu.com/item/%E6%AC%A7%E5%87%A0%E9%87%8C%E5%BE%97%E7%AE%97%E6%B3%95/1647675">source1</a>
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
     * 获取两个非负整数的最大公约数，先获取两数的最大公约数gcd(a,b)后再通过a*b/gcd(a,b)计算获取
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

    /**
     * 分解质因数，获取一个非负整数的质因数列表
     *
     * @param num 被分解质因数的非负整数
     * @return 质因数列表
     * @author Achteins-81
     * @since 2023-03-17
     */
    public static List<Integer> getPrimeFactors(int num) {
        if (num < 0) {
            throw new RuntimeException("被分解的数是负数");
        }
        /*
        从最小的质数2开始检查num能否被整除，能整除则是其质因数，并继续检查能否被再次整除（如避免4作为合数被判断为质因数），
        直到无法被整除，则+1继续检查能否被整除
         */
        int i = 2;
        int temp = num;
        List<Integer> primeFactors = new ArrayList<>();
        while (i <= temp) {
            if (temp % i == 0) {
                primeFactors.add(i);
                temp /= i;
            } else {
                //提升效率的操作，大于2的偶数必为合数，增加i的值时判断是否为偶数，为偶数则+2，使其保持为奇数
                i += (i % 2 == 0 ? 1 : 2);
            }
        }
        return primeFactors;
    }

    /**
     * 分解质因数结果检查，质因数相乘得到数，与被分解的数相减得到差值，差值为0则正确分解，反之分解错误
     *
     * @param num          被分解质因数的非负整数
     * @param primeFactors 质因数列表
     * @return 被分解的数与质因数相乘结果的差值，差值为0时表示正确分解，非0时则分解存在错误
     * @author Achteins-81
     * @since 2023-03-17
     */
    public static int checkPrimeFactors(int num, List<Integer> primeFactors) {
        if (num < 0) {
            throw new RuntimeException("被分解的数是负数");
        }
        if (primeFactors.size() == 0) {
            throw new RuntimeException("质因数列表为空");
        }
        int result = 1;
        for (int i : primeFactors) {
            result *= i;
        }
        return num - result;
    }

}
