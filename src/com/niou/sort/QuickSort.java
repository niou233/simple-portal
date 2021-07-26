package com.niou.sort;

import java.lang.*;
import java.io.*;
import java.util.*;
// 快速排序(Quicksort) O(n*logn)
public class QuickSort{
    public static void main(String[] args){
        int[] a = {27, 91, 1, 97, 17, 23, 84, 28, 72, 5, 67, 25};
        // 打印
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
        QuickSort.sort(a, 0, a.length - 1);
        // 打印结果
        for (int i : a) {
            System.out.print(i + " ");
        }
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
    public static void sort(int a[], int l, int r){
        if(l >= r)return;
        int i = l; int j = r; int key = a[l];
        while(i < j){
            while(i < j && a[j] >= key)j--;//从右向左找第一个小于key的值
            if(i < j){
                a[i] = a[j];
                i++;
            }
            while(i < j && a[i] < key)i++;//从左向右找第一个大于key的值
            if(i < j){
                a[j] = a[i];
                j--;
            }
        }
        // i == j
        a[i] = key;
        QuickSort.sort(a, l, i - 1); // 递归调用
        QuickSort.sort(a, i + 1, r); // 递归调用
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