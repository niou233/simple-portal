package com.niou.sort;

import java.lang.*;
import java.io.*;
import java.util.*;
// 希尔排序(Shell Sort) O(n1.5)
public class ShellSort{
    public static void main(String[] args){
        int[] a = {27, 91, 1, 97, 17, 23, 84, 28, 72, 5, 67, 25};
        // 打印
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
        ShellSort.sort(a);
    }

    /**
     * <pre>
     *  排序
     * </pre>
     * @author 董珊珊
     * @param A 原数组
     * @throws
     * <pre>
     * 修改记录
     *  版本号     修订日期        修改人     bug编号       修改内容
     *  1.0.0      2021/5/11      董珊珊                     新建
     * </pre>
     */
    public static void sort(int a[]){
        int incre = a.length;
        while(incre > 1) {
            incre /=2;
            for(int k = 0; k < incre; k++) { // 根据增量分为若干子序列
                for(int i = k; i < a.length; i += incre) {
                    for(int j = i; j > k; j -= incre) {
                        if(a[j - incre] > a[j]) {
                            ShellSort.swap(a, j - 1, j);
                        }
                    }
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