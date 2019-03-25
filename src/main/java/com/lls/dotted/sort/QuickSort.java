package com.lls.dotted.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

/************************************
 * QuickSort
 * @author liliangshan
 * @date 2019-03-25
 ************************************/
public class QuickSort {
    private static final Logger logger = LoggerFactory.getLogger(QuickSort.class);

    /**
     * 快速排序（递归）
     * <p>
     * ①. 从数列中挑出一个元素，称为"基准"（pivot）。
     * ②. 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
     * ③. 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     *
     * @param arr  待排序数组
     * @param low  左边界
     * @param high 右边界
     */
    public static void quick(int[] arr, int low, int high) {
        if (arr.length <= 0) return;
        if (low >= high) return;
        int left = handleArray(arr, low, high);
        quick(arr, low, left - 1);
        quick(arr, left + 1, high);
    }

    /**
     * 快速排序（非递归）
     * <p>
     * ①. 从数列中挑出一个元素，称为"基准"（pivot）。
     * ②. 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
     * ③. 把分区之后两个区间的边界（low和high）压入栈保存，并循环①、②步骤
     * <p>
     * 快速排序是通常被认为在同数量级（O(nlog2n)）的排序方法中平均性能最好的。
     * 但若初始序列按关键码有序或基本有序时，快排序反而蜕化为冒泡排序。为改进之，通常以“三者取中法”来选取基准记录，
     * 即将排序区间的两个端点与中点三个记录关键码居中的调整为支点记录。快速排序是一个不稳定的排序方法。
     *
     * @param arr 待排序数组
     */
    public static void quickSortByStack(int[] arr) {
        if (arr.length <= 0) return;
        Stack<Integer> stack = new Stack<Integer>();

        //初始状态的左右指针入栈
        stack.push(0);
        stack.push(arr.length - 1);
        while (!stack.isEmpty()) {
            int high = stack.pop();     //出栈进行划分
            int low = stack.pop();

            int pivotIdx = partition(arr, low, high);

            //保存中间变量
            if (pivotIdx > low) {
                stack.push(low);
                stack.push(pivotIdx - 1);
            }
            if (pivotIdx < high && pivotIdx >= 0) {
                stack.push(pivotIdx + 1);
                stack.push(high);
            }
        }
    }

    private static int partition(int[] arr, int low, int high) {
        if (arr.length <= 0) return -1;
        if (low >= high) return -1;
        return handleArray(arr, low, high);
    }

    private static int handleArray(int[] array, int low, int high) {
        int left = low;
        int r = high;

        int pivot = array[left];    //挖坑1：保存基准的值
        while (left < r) {
            while (left < r && array[r] >= pivot) {  //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
                r--;
            }
            array[left] = array[r];
            while (left < r && array[left] <= pivot) {   //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
                left++;
            }
            array[r] = array[left];
        }
        array[left] = pivot;   //基准值填补到坑3中，准备分治递归快排
        return left;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 9, 80, 99, 3, 8, 2, 101, 86, 34, 65, 23, 10, 1};
        logger.info("quick sort before:{}", array);
        quick(array, 0, array.length - 1);
        logger.info("quick sort end:{}", array);

        int[] array2 = new int[]{2, 9, 80, 99, 3, 8, 2, 101, 86, 34, 65, 23, 10, 1};
        logger.info("quickSortByStack sort before:{}", array2);
        quickSortByStack(array2);
        logger.info("quickSortByStack sort end:{}", array2);
    }
}
