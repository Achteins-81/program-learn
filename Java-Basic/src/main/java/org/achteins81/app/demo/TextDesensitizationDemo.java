package org.achteins81.app.demo;

import org.achteins81.app.base.util.CommonUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文本脱敏demo
 *
 * @author Achteins-81
 * @since 2022-11-17
 */
public class TextDesensitizationDemo {
    public static void main(String[] args) {
        desensitizeIdCardInText();
        desensitizeMultipleLengthText();
    }

    /**
     * 文本通过正则匹配特定文本并替换为脱敏处理后的文本
     */
    public static void desensitizeIdCardInText() {
        String text = "a422322197105020048bcdef421201195801010030xyz";
        String regex = "[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        StringBuilder textBuilder = new StringBuilder(text);

        String result;
        int beginIndex;
        int endIndex;
        while (matcher.find()) {
            result = matcher.group();
            beginIndex = matcher.start();
            endIndex = matcher.end();
            try {
                textBuilder.replace(beginIndex, endIndex, CommonUtils.desensitizeTextByType(result, "idCard"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
//            System.out.println(textBuffer);
        }
        String desensitizedText = textBuilder.toString();
        System.out.println(text);
        System.out.println(desensitizedText);
    }

    /**
     * 不同长度的文本脱敏测试
     */
    public static void desensitizeMultipleLengthText() {
        String desStr = CommonUtils.desensitize("15828375982", 3, 4);
        System.out.println(desStr);
        System.out.println(CommonUtils.desensitizeTextByType("蜗牛", "default"));
        System.out.println(CommonUtils.desensitizeTextByType("战斗机", "default"));
        System.out.println(CommonUtils.desensitizeTextByType("战争雷霆", "default"));
        System.out.println(CommonUtils.desensitizeTextByType("class", "default"));
        System.out.println(CommonUtils.desensitizeTextByType("battle", "default"));
        System.out.println(CommonUtils.desensitizeTextByType("Windows", "default"));
        System.out.println(CommonUtils.desensitizeTextByType("胡德号战列巡洋舰", "default"));
        System.out.println(CommonUtils.desensitizeTextByType("123456789", "default"));
        System.out.println(CommonUtils.desensitizeTextByType("举头望明月低头思故乡", "default"));
    }
}
