package com.lls.dotted.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/************************************
 * MergingSort
 * @author liliangshan
 * @date 2019-03-25
 ************************************/
public class MergingSort {

    private static final Logger logger = LoggerFactory.getLogger(MergingSort.class);

    // 归并排序
    public static void sort(int[] array) {
        int length = array.length;
        int[] result = new int[length];

        mergeSortPart(array, result,0, length - 1);
    }

    private static void mergeSortPart(int[] array, int[] result, int start, int end) {
        if (start >= end) {
            return;
        }

        int len = end - start, mid = (len >> 1) + start;
        int start1 = start;
        int start2 = mid + 1;

        mergeSortPart(array, result, start1, mid);
        mergeSortPart(array, result, start2, end);

        int k = start;
        while (start1 <= mid && start2 <= end)
            result[k++] = array[start1] < array[start2] ? array[start1++] : array[start2++];

        while (start1 <= mid)
            result[k++] = array[start1++];

        while (start2 <= end)
            result[k++] = array[start2++];

        for (k = start; k <= end; k++)
            array[k] = result[k];
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 9, 80, 99, 3, 8, 2, 101, 86, 34, 65, 23, 10, 1};
        logger.info("merge sort before:{}", array);
        sort(array);
        logger.info("merge sort end:{}", array);
    }

}
