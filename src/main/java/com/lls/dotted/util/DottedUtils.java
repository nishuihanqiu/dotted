package com.lls.dotted.util;

/************************************
 * DottedUtils
 * @author liliangshan
 * @date 2019-03-25
 ************************************/
public class DottedUtils {

    public static void swap(int[] array, int i, int j) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void swap_1(int[] array, int i, int j) {
        array[i] = array[i] + array[j];
        array[j] = array[i] - array[j];
        array[i] = array[i] - array[j];
    }

    public static void swap_2(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j]; // a = a ^ b;
        array[j] = array[j] ^ array[i]; // b = b ^ a;
        array[i] = array[i] ^ array[j]; // a = a ^ b;
    }

}
