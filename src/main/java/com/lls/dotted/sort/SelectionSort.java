package com.lls.dotted.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/************************************
 * SelectionSort
 * @author liliangshan
 * @date 2019-03-25
 ************************************/
public class SelectionSort {
    private static final Logger logger = LoggerFactory.getLogger(SelectionSort.class);

    /**
     * 选择排序
     * <p>
     * 1. 从待排序序列中，找到关键字最小的元素；
     * 2. 如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
     * 3. 从余下的 N - 1 个元素中，找出关键字最小的元素，重复①、②步，直到排序结束。
     * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * </p>
     *
     * @param array 待排序数组
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 9, 80, 99, 3, 8, 2, 101, 86, 34, 65, 23, 10, 1};
        logger.info("selection sort before:{}", array);
        sort(array);
        logger.info("selection sort end:{}", array);
    }

}
