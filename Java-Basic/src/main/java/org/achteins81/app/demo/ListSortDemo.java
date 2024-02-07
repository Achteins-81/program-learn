package org.achteins81.app.demo;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Achteins-81
 */
public class ListSortDemo {
    public static void main(String[] args) {
        int size = 10;
        List<Integer> list = new ArrayList<>(size);
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt());
        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }
}
