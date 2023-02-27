package org.achteins81.app.demo;

import org.achteins81.app.base.util.CommonUtils;

/**
 * 随机复杂密码生成demo
 *
 * @author Achteins-81
 * @since 2023-01-26
 */
public class RandomPasswordDemo {
    public static void main(String[] args) {
        System.out.println(CommonUtils.getRandomPassword(8));
        System.out.println(CommonUtils.getRandomPassword(8));
        System.out.println(CommonUtils.getRandomPassword(20));
        System.out.println(CommonUtils.getRandomPassword(6));
        System.out.println(CommonUtils.getRandomPassword(24));
    }
}
