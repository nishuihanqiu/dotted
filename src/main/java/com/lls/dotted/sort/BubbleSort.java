package com.lls.dotted.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/************************************
 * BubbleSort
 * @author liliangshan
 * @date 2019-03-25
 ************************************/
public class BubbleSort {

    private static final Logger logger = LoggerFactory.getLogger(BubbleSort.class);

    /**
     * 冒泡排序
     * <p>
     * ①. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * ②. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * ③. 针对所有的元素重复以上的步骤，除了最后一个。
     * ④. 持续每次对越来越少的元素重复上面的步骤①~③，直到没有任何一对数字需要比较。
     * <p>
     * 冒泡排序是最容易实现的排序, 最坏的情况是每次都需要交换, 共需遍历并交换将近n²/2次, 时间复杂度为O(n²).
     * 最佳的情况是内循环遍历一次后发现排序是对的, 因此退出循环, 时间复杂度为O(n). 平均来讲, 时间复杂度为O(n²).
     * 由于冒泡排序中只有缓存的temp变量需要内存空间, 因此空间复杂度为常量O(1).
     * 由于冒泡排序只在相邻元素大小不符合要求时才调换他们的位置, 它并不改变相同元素之间的相对顺序, 因此它是稳定的排序算法.
     *
     * @param array 待排序数组
     */
    public static void sort(int[] array) {
        for (int i = array.length; i > 0; i--) {      //外层循环移动游标
            for (int j = 0; j < i && (j + 1) < i; j++) {    //内层循环遍历游标及之后(或之前)的元素
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 9, 80, 99, 3, 8, 2, 101, 86, 34, 65, 23, 10, 1};
        logger.info("bubble sort before:{}", array);
        sort(array);
        logger.info("bubble sort end:{}", array);
    }

}
