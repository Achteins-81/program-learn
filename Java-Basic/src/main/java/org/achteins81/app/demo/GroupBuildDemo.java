package org.achteins81.app.demo;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一个随机分组demo，每组只能是2至3个成员
 *
 * @author Achteins-81
 * @since 2023-02-03
 */
public class GroupBuildDemo {
    private static final String[] MEMBERS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};

    private static final int GROUP_SIZE_LOWER_LIMIT = 2;
    private static final int GROUP_SIZE_UPPER_LIMIT = 3;

    public static void main(String[] args) {
        buildGroup();
    }

    /**
     * 分组
     */
    private static void buildGroup() {
        SecureRandom random = new SecureRandom();
        List<String> remainedMembers = new ArrayList<>(Arrays.asList(MEMBERS));
        List<List<String>> groupedMembers = new ArrayList();
        List<String> tempGroup = new ArrayList();
        String tempMember;

        int tempGroupSize;
        int tempMemberIndex;

        int groupIndex = 0;

        while (remainedMembers.size() > 0) {
            //确定分组成员数
            //原则：1.符合分组成员数要求范围；2.该次分组后，剩余未分组成员仍然可按照第1条进行分组，3.已生产的分组不再通过后续分配递补
            if (remainedMembers.size() >= GROUP_SIZE_LOWER_LIMIT && remainedMembers.size() <= GROUP_SIZE_UPPER_LIMIT) {
                tempGroupSize = remainedMembers.size();
            } else /*if (remainedMembers.size() > GROUP_SIZE_LOWER_LIMIT)*/ {//剩余成员数大于最小值时，添加一个随机数，且不超过最大值
                tempGroupSize = GROUP_SIZE_LOWER_LIMIT + random.nextInt((Math.min(GROUP_SIZE_UPPER_LIMIT, remainedMembers.size() - GROUP_SIZE_LOWER_LIMIT)) - Math.min(GROUP_SIZE_LOWER_LIMIT, remainedMembers.size() - GROUP_SIZE_LOWER_LIMIT) + 1);
            }
            System.out.println("group:" + groupIndex + ",size:" + tempGroupSize);
            for (int i = 1; i <= tempGroupSize; i++) {
                tempMemberIndex = remainedMembers.size() > 1 ? random.nextInt(remainedMembers.size()) : 0;
                System.out.println("group:" + groupIndex + ",index:" + tempMemberIndex);
                tempMember = remainedMembers.get(tempMemberIndex);
                System.out.println("group:" + groupIndex + ",member:" + tempMember);
                tempGroup.add(tempMember);
                remainedMembers.remove(tempMember);
                System.out.println("remained:" + remainedMembers);
                if (tempGroup.size() == tempGroupSize) {
                    groupedMembers.add(tempGroup);
                    System.out.println("group:" + groupIndex + ",members:" + tempGroup);
                    tempGroup = new ArrayList<>();
                    groupIndex++;
                }
                System.out.println("remained:" + remainedMembers);
            }
        }
        System.out.println("result:" + groupedMembers);
    }
}
