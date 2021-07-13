package com.niou.DesignPatterns.strategy;

import java.util.Comparator;

// 冒泡排序(BubbleSort)  O(n2)
public class Sort<T> {
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
    public void sort(T[] a, Comparator<T> c){
        for(int i = 1; i < a.length; i++) { // 表示趟数，一共arr.length-1次。
            for(int j = 0; j < a.length - i; j++) {
                if(c.compare(a[j], a[j + 1]) == 1) {
                    this.swap(a, j, j+1);
                }
            }
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
    public void swap(T[] a, int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}