package com.niou.sort;

import java.lang.*;
import java.io.*;
import java.util.*;

// 冒泡排序(BubbleSort)  O(n2)
public class BubbleSort {
    public static void main(String[] args){
        int[] a = {27, 91, 1, 97, 17, 23, 84, 28, 72, 5, 67, 25};
        // 打印
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
        BubbleSort.sort(a);
    }

    /**
     * <pre>
     *  排序
     * </pre>
     * @author 董珊珊
     * @param a 原数组
     * @throws
     * <pre>
     * 修改记录
     *  版本号     修订日期        修改人     bug编号       修改内容
     *  1.0.0      2021/5/11      董珊珊                     新建
     * </pre>
     */
    public static void sort(int a[]){
        for(int i = 1; i < a.length; i++) { // 表示趟数，一共arr.length-1次。
            for(int j = 0; j < a.length - i; j++) {
                if(a[j] > a[j + 1]) {
                    BubbleSort.swap(a, j, j+1);
                }
            }
        }
        // 打印结果
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    /**
     * <pre>
     * 交换
     * </pre>
     * @author 董珊珊
     * @param a 原数组
     * @param i 交换对象1位置
     * @param j 交换对象2位置
     * @return void
     * @throws
     * <pre>
     * 修改记录
     *  版本号     修订日期        修改人     bug编号       修改内容
     *  1.0.0      2021/5/12      董珊珊                     新建
     * </pre>
     */
    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}