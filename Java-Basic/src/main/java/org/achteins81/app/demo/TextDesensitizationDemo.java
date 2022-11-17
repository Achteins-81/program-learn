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
}
