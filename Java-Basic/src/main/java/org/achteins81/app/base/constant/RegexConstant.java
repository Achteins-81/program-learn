package org.achteins81.app.base.constant;

/**
 * 正则表达式(Regular Expression)常量类
 *
 * @author Achteins-81
 * @since 2023-03-29
 */
public class RegexConstant {
    /**
     * 数字正则，可包含小数与负号
     */
    public static final String REGEX_DECIMAL = "(-)?[\\d]*(.)?[\\d]*";

    /**
     * 数字正则，可包含小数、负号与逗号分隔符
     */
    public static final String REGEX_DECIMAL_FORMATTED_COMMA = "(-)?[\\d]{1,3}(,[\\d]{3})*(.)?[\\d]*";
}
