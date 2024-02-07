package org.achteins81.app.demo;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        int size = 10;
        int[] array = new int[size];
        try {
            for (int i = 0; i < size; i++) {
                array[i] = i;
            }
            System.out.println("step 1:");
            for (int j : array) {
                System.out.println(j);
            }
            array[size] = size;
        } catch (Exception e) {
//            e.printStackTrace();
            array = Arrays.copyOf(array, array.length + 1);
            array[size] = size;
            System.out.println("step 2:");
            for (int i : array) {
                System.out.println(i);
            }
        }

        int[] anotherArray = {};
        try {
            for (int i = 0; i < size; i++) {
                anotherArray[i] = i;
            }
            anotherArray[size] = size;
            System.out.println("another:");
            for (int j : anotherArray) {
                System.out.println(j);
            }
        } catch (Exception e) {
//            throw new RuntimeException(e);
            anotherArray = Arrays.copyOf(anotherArray, anotherArray.length + 11);
            for (int i = 0; i < size; i++) {
                anotherArray[i] = i;
            }
            anotherArray[size] = size;
            System.out.println("another:");
            for (int j : anotherArray) {
                System.out.println(j);
            }
        }
    }
}
