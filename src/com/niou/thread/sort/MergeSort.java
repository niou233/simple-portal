package com.niou.thread.sort;

/**
 * <pre>
 * @ClassName MergeSort.java
 * </pre>
 *
 * @author Niou<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/06/26 18:47<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/06/26 	Niou		    		新建
 * </pre>
 */
public class MergeSort {
    public static void sort(int[] array) {
        int length = array.length;
        int[] tmpArray = new int[length];
        sort(array, tmpArray, 0, length - 1);
    }

    public static void sort(int[] array, int[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;    //取中间值
            sort(array, tmpArray, left, center);    //递归分解
            sort(array, tmpArray, center + 1, right);    //递归分解
            merge(array, tmpArray, left, center + 1, right);    //合并排序
        }
    }

    private static void merge(int[] array, int[] tmpArray, int leftStart, int rightStart, int rightEnd) {
        int leftEnd = rightStart - 1;    //左侧数组截止下标
        int tmpPos = leftStart;    //数组坐标
        int total = rightEnd - leftStart + 1;    //需要合并的数组元素数量

        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (array[leftStart] <= array[rightStart]) {
                //如果左侧数组元素小于或等于右侧数组元素，将左侧数组元素的值存入临时数组，并移动左侧数组下标
                tmpArray[tmpPos++] = array[leftStart++];
            } else {
                //如果左侧数组元素大于右侧数组元素，将右侧数组元素的值存入临时数组，并移动右侧数组下标
                tmpArray[tmpPos++] = array[rightStart++];
            }
        }

        //如果左侧数组元素没有全部存入临时数组，将剩余元素循环写入临时数组
        while (leftStart <= leftEnd) {
            tmpArray[tmpPos++] = array[leftStart++];
        }

        //如果右侧数组元素没有全部存入临时数组，将剩余元素循环写入临时数组
        while (rightStart <= rightEnd) {
            tmpArray[tmpPos++] = array[rightStart++];
        }

        //将临时数组中排序好的元素写入原数组
        for (int i = 0; i < total; i++, rightEnd--) {
            array[rightEnd] = tmpArray[rightEnd];
        }

    }
}
