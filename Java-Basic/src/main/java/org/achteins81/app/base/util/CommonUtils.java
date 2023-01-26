package org.achteins81.app.base.util;

import org.achteins81.app.base.constant.BaseConstant;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 工具方法类
 *
 * @author Achteins-81
 * @since 2022-11-17
 */
public class CommonUtils {
    static SecureRandom innerSecureRandom = new SecureRandom();

    /**
     * 随机获取字符串字符
     *
     * @param param 字符串
     * @return  随机字符
     */
    private static char getRandomChar(String param) {
        SecureRandom random = new SecureRandom();
        return param.charAt(random.nextInt(param.length()));
    }

    /**
     * 随机获取数字字符
     *
     * @return  随机数字字符
     */
    private static char getRandomNum() {
        return getRandomChar(BaseConstant.NUMBER_STRING);
    }

    /**
     * 随机获取小写字母字符
     *
     * @return  随机小写字符字符
     */
    private static char getRandomLowerChar() {
        return getRandomChar(BaseConstant.LOWER_CAPITAL_STRING);
    }

    /**
     * 随机获取大写字母字符
     *
     * @return  随机大写字母字符
     */
    private static char getRandomUpperChar() {
        return Character.toUpperCase(getRandomLowerChar());
    }

    /**
     * 随机获取特殊字符
     *
     * @return  随机特殊字符
     */
    private static char getRandomSpecialChar() {
        return getRandomChar(BaseConstant.SPECIAL_CHARACTER_STRING);
    }

    /**
     * 获取指定类型随机字符
     *
     * @param type 随机字符类型，0-数字，1-小写字符，2-大写字符，3-特殊字符，其它值则在0,1,2,3中随机取值获取随机字符
     * @return  随机字符
     */
    private static char getRandomCharByType(int type) {
        switch (type) {
            case 0:
                return getRandomNum();
            case 1:
                return getRandomLowerChar();
            case 2:
                return getRandomUpperChar();
            case 3:
                return getRandomSpecialChar();
            default:
                return getRandomCharByType(innerSecureRandom.nextInt(4));
        }
    }

    /**
     * 文本脱敏，按传入类型(type)对文本(text)做脱敏处理
     *
     * @param text 待脱敏文本
     * @param type 脱敏类型
     * @return 脱敏后文本
     */
    public static String desensitizeTextByType(String text, String type) {
        String resText;
        switch (type) {
            case "idCard":
                resText = desensitize(text, 6, 4);
                break;
            case "phoneNumber":
                resText = desensitize(text, 3, 4);
                break;
            case "bankCard":
                resText = desensitize(text, 3, 3);
                break;
            case "default":
            default:
                if (text.length() == 2) {
                    resText = desensitize(text, 1, 0);
                } else if (text.length() == 3 || text.length() == 4) {
                    resText = desensitize(text, 1, 1);
                } else if (text.length() == 5) {
                    resText = desensitize(text, 2, 1);
                } else if (text.length() == 6) {
                    resText = desensitize(text, 2, 2);
                } else if (text.length() == 7) {
                    resText = desensitize(text, 2, 2);
                } else if (text.length() == 8) {
                    resText = desensitize(text, 2, 3);
                } else if (text.length() == 9) {
                    resText = desensitize(text, 2, 3);
                } else if (text.length() > 9) {
                    resText = desensitize(text, 3, 3);
                } else {
                    resText = text;
                }
                break;
        }
        return resText;
    }

    /**
     * 文本脱敏，通过传入参数中前后保留长度，对文本中部进行脱敏转换<br/>
     * JavaScript版本参考：<a href="https://juejin.cn/post/6844903812725997575">source</a>
     *
     * @param text     待脱敏文本
     * @param beginLen 前段保留长度
     * @param endLen   末段保留长度
     * @return 脱敏后文本
     */
    public static String desensitize(String text, int beginLen, int endLen) {
        int length = text.length();
        String firstStr = text.substring(0, beginLen);
        String lastStr = text.substring(length - endLen, length);
        String middleStr = text.substring(beginLen, length - endLen).replaceAll("[\\S\\s]", "*");
        return (firstStr + middleStr + lastStr);
    }

    /**
     * 生成指定长度的随机复杂密码
     *
     * @param length 密码长度
     * @return 密码
     * @see <a href="https://blog.csdn.net/qingquanyingyue/article/details/106336742">source</a>
     */
    public static String getRandomPassword(int length) {
        //密码长度参数值检查，值不在8至20的要求范围时，从中取随机值
        if (length < 8 || length > 20) {
            length = 8 + innerSecureRandom.nextInt(13);
        }

        List<Character> list = new ArrayList<>(length);
        //把 4 种字符每种随机选一个放进 list
        list.add(getRandomNum());
        list.add(getRandomLowerChar());
        list.add(getRandomUpperChar());
        list.add(getRandomSpecialChar());

        //根据密码长度要求再随机选择4种字符放进list
        for (int i = 4; i < length; i++) {
            int type = innerSecureRandom.nextInt(4);
            list.add(getRandomCharByType(type));
        }

        //list 重新排序
        Collections.shuffle(list);
        //list 遍历组合成字符串输出
        StringBuilder password = new StringBuilder();
        for (Character c : list) {
            password.append(c);
        }

        return password.toString();
    }

}
