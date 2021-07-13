package com.niou.sort;

import java.lang.*;
import java.io.*;
import java.util.*;

// 基数/桶排序(RadixSort) O(n*logn)
public class RadixSort {
    public static void main(String[] args){
        int[] a = {27, 91, 1, 97, 17, 23, 84, 28, 72, 5, 67, 25};
        // 打印
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
        RadixSort.sort(a, 2, 10);
    }

    /**
     * <pre>
     *  桶排序，基数binsort的改进排序方法
     * </pre>
     * @author 董珊珊
     * @param A 原数组
     * @param k 最大位数
     * @param r 基数
     * @return void
     * @throws
     * <pre>
     * 修改记录
     *  版本号     修订日期        修改人     bug编号       修改内容
     *  1.0.0      2021/5/11      董珊珊                     新建
     * </pre>
     */
    public static void sort(int a[], int k, int r){
        int n = a.length; // 长度
        int[] temp = new int[a.length]; // 临时数组
        int[] cnt = new int[r]; // 存储bin[i]的个数

        for(int i = 0, rtok = 1; i < k; i++, rtok *= r) { // 循环位数
            // 初始化
            for(int j = 0; j < r; j++){
                cnt[j] = 0;
            }
            // 计算每个箱子的数字个数
            for(int j = 0; j < n; j++) {
                cnt[(a[j]/rtok)%r]++; // 当前位上的数取余，判断在什么位置增加计数
            }
            // cnt[j]的个数修改为前j个箱子一共有几个数字
            for(int j = 1; j < r; j++) {
                cnt[j] =  cnt[j - 1] + cnt[j];
            }
            for(int j = n - 1; j >= 0; j--) {
                cnt[(a[j]/rtok)%r]--;
                temp[cnt[(a[j]/rtok)%r]] = a[j]; // 某位的位置区间上放置排序对象
            }
            for(int j = 0; j < n; j++){
                a[j] = temp[j];
            }
        }
        // 打印结果
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}