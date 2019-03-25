package com.lls.dotted.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/************************************
 * ShellSort
 * @author liliangshan
 * @date 2019-03-25
 *
 ************************************/
public class ShellSort {

    private static final Logger logger = LoggerFactory.getLogger(ShellSort.class);

    /**
     * 希尔排序
     * <p>
     * 1. 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；（一般初次取数组半长，之后每次再减半，直到增量为1）
     * 2. 按增量序列个数k，对序列进行k 趟排序；
     * 3. 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
     * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * </p>
     *
     * @param array 待排序数组
     */
    public static void sort(int[] array) {
        int gap = array.length / 2;
        int i;
        int j;
        int temp;

        while (gap >= 1) {
            for (i = gap; i < array.length; i++) {
                temp = array[i];
                j = i - gap;
                while (j >= 0 && array[j] > temp) { //需要注意的是，这里array[j] < temp将会使数组从大到小排序。
                    array[j + gap] = array[j];
                    j = j - gap;
                }
                array[j + gap] = temp;
            }
            gap = gap / 2;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 9, 80, 99, 3, 8, 2, 101, 86, 34, 65, 23, 10, 1};
        logger.info("shell sort before:{}", array);
        sort(array);
        logger.info("shell sort end:{}", array);
    }

}
