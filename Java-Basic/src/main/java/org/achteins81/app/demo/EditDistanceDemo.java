package org.achteins81.app.demo;

import org.achteins81.app.base.object.EditDistance;

/**
 * 编辑距离Demo
 *
 * @author Achteins-81
 * @since 2022-11-18
 */
public class EditDistanceDemo {
    public static void main(String[] args) {
        String str1 = "102923114";
        String str2 = "102923319";
        System.out.println("字符串相似度: " + new EditDistance().similar(str1, str2));
    }
}
