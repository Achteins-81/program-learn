package org.achteins81.app.demo;

public class ConstantDemo {
    //十进制
    public static int decimalNumber = 345;
    //八进制
    public static int octalNumber = 01235;
    //十六进制
    public static int hexadecimalNumber = 0x131a;

    public static void main(String[] args) {
        System.out.println(decimalNumber);
        System.out.printf("%x\n", decimalNumber);
        System.out.printf("%o\n", octalNumber);
    }
}
