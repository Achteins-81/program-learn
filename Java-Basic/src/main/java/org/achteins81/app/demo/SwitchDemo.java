package org.achteins81.app.demo;

import java.util.Random;

public class SwitchDemo {
    public static void main(String[] args) {
        int num = new Random().nextInt();
        switchAndPrint(num);
    }

    public static void switchAndPrint(int num) {
        System.out.println(num);

        byte mod = (byte) (num % 10);
        String resStr = "";
        switch (mod) {
            case 1:
            case 2:
            case 3:
            case 4:
                resStr = "abc";
                break;
            case 5:
            case 6:
            case 7:
                resStr = "def";
                break;
            case 8:
            case 9:
                resStr = "ghi";
                break;
            case 0:
                resStr = "jkl";
                break;
        }
        System.out.printf("[%d],[%d],[%s]", num, mod, resStr);
    }
}
