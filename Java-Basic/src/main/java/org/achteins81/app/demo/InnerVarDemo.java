package org.achteins81.app.demo;

public class InnerVarDemo {
    public static void main(String[] args) {
        String a = "a";
        String b = test(a);
        System.out.println(a);
        System.out.println(b);
    }

    private static String test(String a) {
        a = "ab";
        return a;
    }
}
