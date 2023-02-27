package org.achteins81.app.demo;

import org.achteins81.app.base.constant.BaseConstant;
import org.achteins81.app.base.util.MathUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 天干地支遍历组合demo
 *
 * @author Achteins-81
 * @since 2023-02-27
 */
public class StemsAndBranchesDemo {
    public static void main(String[] args) {
        getStemsAndBranchesWithForLoop();
        getStemsAndBranchesWithDoWhile();
    }

    /**
     * 天干地支遍历组合，使用for循环遍历，循环次数为天干和地支两者数量的最小公倍数
     */
    public static void getStemsAndBranchesWithForLoop() {
        String[] heavenlyStems = BaseConstant.HEAVENLY_STEMS.split("");
        String[] earthlyBranches = BaseConstant.EARTHLY_BRANCHES.split("");
        List<String> stemsAndBranches = new ArrayList<>();
        String stemAndBranch;
        int stemsLength = heavenlyStems.length;
        int branchesLength = earthlyBranches.length;
        int total = MathUtils.getLeastCommonMultiple(stemsLength, branchesLength);
        int i;
        for (i = 0; i < total; i++) {
            stemAndBranch = heavenlyStems[i % stemsLength] + earthlyBranches[i % branchesLength];
            stemsAndBranches.add(stemAndBranch);
        }
        System.out.printf("天干地支：%s%n循环次数：%d%n", stemsAndBranches, i);
    }

    /**
     * 天干地支遍历组合，使用do while循环遍历，当新组合得到的干支在组合列表中已存在时结束循环
     */
    public static void getStemsAndBranchesWithDoWhile() {
        String[] heavenlyStems = BaseConstant.HEAVENLY_STEMS.split("");
        String[] earthlyBranches = BaseConstant.EARTHLY_BRANCHES.split("");
        List<String> stemsAndBranches = new ArrayList<>();
        String stemAndBranch = "";
        int stemsLength = heavenlyStems.length;
        int branchesLength = earthlyBranches.length;
        int i = 0;
        do {
            if (!"".equals(stemAndBranch)) {
                stemsAndBranches.add(stemAndBranch);
            }
            stemAndBranch = heavenlyStems[i % stemsLength] + earthlyBranches[i % branchesLength];
            i++;
        } while (!stemsAndBranches.contains(stemAndBranch));
        System.out.printf("天干地支：%s%n循环次数：%d%n", stemsAndBranches, i);
    }
}
