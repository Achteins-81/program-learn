package org.achteins81.app.demo;

import org.achteins81.app.base.util.ChnSpecialUtils;

/**
 * 中文特有内容demo
 *
 * @author Achteins-81
 * @since 2023-03-30
 */
public class ChnSpecialDemo {
    public static void main(String[] args) {
        String number = "5060001000045.04345";
        System.out.println(ChnSpecialUtils.upperCharacterizeCNY(number));
    }
}
