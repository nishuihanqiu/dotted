package com.lls.dotted.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/************************************
 * InsertionSort
 * @author liliangshan
 * @date 2019-03-25
 * 直接插入排序
 ************************************/
public class InsertionSort {

  private static final Logger logger = LoggerFactory.getLogger(InsertionSort.class);

  /**
   * 插入排序
   * <p>
   * 1. 从第一个元素开始，该元素可以认为已经被排序
   * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
   * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
   * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
   * 5. 将新元素插入到该位置后
   * 6. 重复步骤2~5
   * </p>
   *
   * @param array 待排序数组
   */
  public static void sort(int[] array) {
    if (array.length <= 1) {
      return;
    }

    for (int i = 0; i < array.length - 1; i++) {
      for (int j = i + 1; j > 0; j--) {
        if (array[j - 1] <= array[j]) {
          break;
        }
        int temp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = temp;
      }
    }

  }


  public static void main(String[] args) {
    int[] array = new int[]{1, 9, 80, 99, 3, 8, 2, 101, 86, 34, 65, 23, 10};
    logger.info("before:{}", array);
    sort(array);
    logger.info("end:{}", array);
  }

}
