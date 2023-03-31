package org.achteins81.app.base.util;

import org.achteins81.app.base.constant.MathConstant;
import org.achteins81.app.base.constant.RegexConstant;
import org.apache.commons.lang.StringUtils;

/**
 * 中文内容专用工具类
 *
 * @author Achteins-81
 * @since 2023-03-29
 */
public class ChnSpecialUtils {
    /**
     * 人民币金额大写整数部分单位
     */
    private static final String[] CNY_UPPER_INTEGER_UNITS = {"圆", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万",
            "拾", "佰", "仟"};
    /**
     * 人民币金额大写小数部分单位
     */
    private static final String[] CNY_UPPER_DECIMAL_UNITS = {"角", "分", "厘"};

    /**
     * 数字的整数、小数部分，用于转换成金额大写时区分处理单位
     */
    enum Part {
        /**
         * 整数
         */
        INTEGER,
        /**
         * 小数
         */
        DECIMAL
    }

    /**
     * 人民币金额大写转换，目前支持最大万亿级的数字
     *
     * @param cnyNumStr 金额/数字字符串
     * @return 金额/数字的人民币金额大写字符串
     * @see <a href="https://www.w3cschool.cn/article/78695508.html">source</a>
     * @since 2023-03-29
     */
    public static String upperCharacterizeCNY(String cnyNumStr) {
        //检查参数是否符合格式
        if (StringUtils.isBlank(cnyNumStr)) {
            throw new RuntimeException("参数不能为空");
        }
        if (!cnyNumStr.matches(RegexConstant.REGEX_DECIMAL) && !cnyNumStr.matches(RegexConstant.REGEX_DECIMAL_FORMATTED_COMMA)) {
            throw new RuntimeException("参数不满足数字格式");
        }
        //判断是否存在负号
        boolean isNegative = cnyNumStr.startsWith("-");
        if (!isNegative) {
            cnyNumStr = cnyNumStr.replaceAll("-", "");
        }
        //判断是否存在逗号分隔
        if (cnyNumStr.contains(MathConstant.NUMBER_THOUSANDS_SEPARATOR)) {
            cnyNumStr = cnyNumStr.replaceAll(MathConstant.NUMBER_THOUSANDS_SEPARATOR, "");
        }
        //分离出整数部分和小数部分
        String integerStr;
        String decimalStr;
        //判断小数点的位置
        if (cnyNumStr.indexOf(".") > 0) {
            //既有整数也有小数
            integerStr = cnyNumStr.split("\\.")[0];
            decimalStr = cnyNumStr.split("\\.")[1];
        } else if (cnyNumStr.indexOf(".") == 0) {
            //只有小数部分，如0.12
            integerStr = "";
            decimalStr = cnyNumStr.split("\\.")[1];
        } else {
            //只有整数
            integerStr = cnyNumStr.split("\\.")[0];
            decimalStr = "";
        }
        //整数部分长度检查，目前只支持万亿级
        if (integerStr.length() > CNY_UPPER_INTEGER_UNITS.length) {
            throw new RuntimeException("整数部分超长");
        }

        return toCNYUpperString(integerStr, Part.INTEGER) + toCNYUpperString(decimalStr, Part.DECIMAL);
    }

    /**
     * 整数字符串转换为人民币大写
     *
     * @param integerStr 整数字符串
     * @param part       转换模式，integer整数，decimal小数，待修改为枚举类型
     * @return 转换为人民币大写的字符串
     */
    private static String toCNYUpperString(String integerStr, Part part) {
        //判断空值并处理
        if (StringUtils.isBlank(integerStr)) {
            return "";
        }
        //转换为整数数组
        int[] integers = toIntegerArray(integerStr);
        //数组长度
        int length = integers.length;
        //人民币大写字符串，返回值
        StringBuilder cnyUpperStirng = new StringBuilder();
        //作为字符串从左到右的索引
        int i;
        if (Part.INTEGER.equals(part)) {
            //整数部分
            //作为数字从小到大（从右到左）的索引
            int numIndex;
            int tempInt;
            for (i = 0; i < length; i++) {
                numIndex = length - i - 1;
                if (integers[i] == 0) {
                    //数字为0
                    if (numIndex == 0) {
                        //个位作为最后一位补充“圆”
                        cnyUpperStirng.append(CNY_UPPER_INTEGER_UNITS[numIndex]);
                    } else if (numIndex % 4 == 0) {
                        //单位为万或亿
                        //截取该位前的整数
                        tempInt = Integer.parseInt(integerStr.substring(0, i + 1));
                        //判断截取整数是否为万或亿的整数倍，是则需要添加单位
                        if (tempInt % Math.pow(10000, (numIndex % 8 == 0 ? 2 : 1)) != 0) {
                            cnyUpperStirng.append(CNY_UPPER_INTEGER_UNITS[numIndex]);
                        }
                    } else if (integers[i + 1] != 0) {
                        //补零
                        cnyUpperStirng.append(MathConstant.CAPITAL_NUMBER_CHINESE_ARRAY[0]);
                    }
                } else {
                    //数字不为0，转换为中文大写数字并添加单位
                    cnyUpperStirng.append(MathConstant.CAPITAL_NUMBER_CHINESE_ARRAY[integers[i]]).append(CNY_UPPER_INTEGER_UNITS[numIndex]);
                }
            }
        } else if (Part.DECIMAL.equals(part)) {
            //小数部分
            for (i = 0; i < Math.min(length, CNY_UPPER_DECIMAL_UNITS.length); i++) {
                if (integers[i] != 0) {
                    cnyUpperStirng.append(MathConstant.CAPITAL_NUMBER_CHINESE_ARRAY[integers[i]]).append(CNY_UPPER_DECIMAL_UNITS[i]);
                }
            }
        }
        return cnyUpperStirng.toString();
    }

    /**
     * 整数字符串转换为数组
     *
     * @param number 整数字符串
     * @return 整数数组
     */
    private static int[] toIntegerArray(String number) {
        int[] array = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            array[i] = Integer.parseInt(number.substring(i, i + 1));
        }
        return array;
    }
}
