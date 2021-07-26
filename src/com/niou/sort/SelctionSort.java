package com.niou.sort;

import java.lang.*;
import java.io.*;
import java.util.*;
// 选择排序(SelctionSort) O(n2)
public class SelctionSort{
    public static void main(String[] args){
        int[] a = {27, 91, 1, 97, 17, 23, 84, 28, 72, 5, 67, 25};
        // 打印
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
        SelctionSort.sort(a);
    }

    /**
     * <pre>
     *  排序
     * </pre>
     * @author niou
     * @param A 原数组
     * @throws
     * <pre>
     * 修改记录
     *  版本号     修订日期        修改人     bug编号       修改内容
     *  1.0.0      2021/5/11      niou                     新建
     * </pre>
     */
    public static void sort(int a[]){
        for(int i = 0; i < a.length - 1; i++) {
            int midIndex = i;
            for(int j = i; j < a.length; j++) {
                if(a[midIndex] > a[j]) {
                    midIndex = j;
                }
                if(midIndex != i) {
                    SelctionSort.swap(a, i, midIndex);
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
     * @author niou
     * @param a 原数组
     * @param i 交换对象1位置
     * @param j 交换对象2位置
     * @return void
     * @throws
     * <pre>
     * 修改记录
     *  版本号     修订日期        修改人     bug编号       修改内容
     *  1.0.0      2021/5/12      niou                     新建
     * </pre>
     */
    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}