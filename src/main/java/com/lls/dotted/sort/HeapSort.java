package com.lls.dotted.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/************************************
 * HeapSort
 * @author liliangshan
 * @date 2019-03-25
 ************************************/
public class HeapSort {

    private static final Logger logger = LoggerFactory.getLogger(HeapSort.class);

    /**
     * 堆排序
     * <p>
     * 1. 先将初始序列K[1..n]建成一个大顶堆, 那么此时第一个元素K1最大, 此堆为初始的无序区.
     * 2. 再将关键字最大的记录K1 (即堆顶, 第一个元素)和无序区的最后一个记录 Kn 交换, 由此得到新的无序区K[1..n−1]和有序区K[n], 且满足K[1..n−1].keys⩽K[n].key
     * 3. 交换K1 和 Kn 后, 堆顶可能违反堆性质, 因此需将K[1..n−1]调整为堆. 然后重复步骤②, 直到无序区只有一个元素时停止.
     * <p>
     * 由于堆排序中初始化堆的过程比较次数较多, 因此它不太适用于小序列. 同时由于多次任意下标相互交换位置, 相同元素之间原本相对的顺序被破坏了, 因此, 它是不稳定的排序.
     *
     * @param array 待排序数组
     */
    public static void sort(int[] array) {
        for (int i = array.length; i > 0; i--) {
            max_heapify(array, i);

            int temp = array[0];      //堆顶元素(第一个元素)与Kn交换
            array[0] = array[i - 1];
            array[i - 1] = temp;
        }
    }

    /**
     * 以上,
     * ①. 建立堆的过程, 从length/2 一直处理到0, 时间复杂度为O(n);
     * ②. 调整堆的过程是沿着堆的父子节点进行调整, 执行次数为堆的深度, 时间复杂度为O(log(n));
     * ③. 堆排序的过程由n次第②步完成, 时间复杂度为O(n*log(n)).
     *
     * @param array 待排序数组
     * @param limit 限制长度
     */
    private static void max_heapify(int[] array, int limit) {
        if (array.length <= 0 || array.length < limit) return;

        for (int parentIdx = limit / 2; parentIdx >= 0; parentIdx--) {
            if (parentIdx * 2 >= limit) {
                continue;
            }
            int left = parentIdx * 2;       //左子节点位置
            int right = (left + 1) >= limit ? left : (left + 1);    //右子节点位置，如果没有右节点，默认为左节点位置

            int maxChildId = array[left] >= array[right] ? left : right;
            if (array[maxChildId] > array[parentIdx]) {   //交换父节点与左右子节点中的最大值
                int temp = array[parentIdx];
                array[parentIdx] = array[maxChildId];
                array[maxChildId] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 9, 80, 99, 3, 8, 2, 101, 86, 34, 65, 23, 10, 1};
        logger.info("heap sort before:{}", array);
        sort(array);
        logger.info("heap sort end:{}", array);
    }
}
