package org.achteins81.app.base.util;

/**
 * 工具方法类
 *
 * @author Achteins-81
 * @since 2022-11-17
 */
public class CommonUtils {
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

    public static void main(String[] args) {
        String desStr = desensitize("15828375982", 3, 4);
        System.out.println(desStr);
        System.out.println(desensitizeTextByType("蜗牛", "default"));
        System.out.println(desensitizeTextByType("战斗机", "default"));
        System.out.println(desensitizeTextByType("战争雷霆", "default"));
        System.out.println(desensitizeTextByType("class", "default"));
        System.out.println(desensitizeTextByType("battle", "default"));
        System.out.println(desensitizeTextByType("Windows", "default"));
        System.out.println(desensitizeTextByType("胡德号战列巡洋舰", "default"));
        System.out.println(desensitizeTextByType("123456789", "default"));
        System.out.println(desensitizeTextByType("举头望明月低头思故乡", "default"));
    }
}
