package com.niou.thread.sort;

import java.util.concurrent.CountDownLatch;

/**
 * <pre>
 * @ClassName ThreadDemo2_5.java
 * </pre>
 *
 * @author Niou<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/06/26 18:50<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/06/26 	Niou		    		新建
 * </pre>
 */
public class ThreadDemo2_5 {
    public void mergeSort(int[] array) throws InterruptedException {
        int length = array.length;

        int minLength = length / 2;
        int[] a = new int[minLength];
        int[] b = new int[minLength];

        for (int i = 0; i < 2; i++) {
            int start = minLength * i;
            int end = minLength * (i + 1);

            if (i == 0) {
                for (int j = start, k = 0; j < end; j++, k++) {
                    a[k] = array[j];
                }
            } else if (i == 1) {
                for (int j = start, k = 0; j < end; j++, k++) {
                    b[k] = array[j];
                }
            }
        }

        //使用CountDownLatch来确保两个子线程都处理完毕后才执行最后的归并操作
        CountDownLatch latch = new CountDownLatch(2);
        new Thread(new Runnable() {

            @Override
            public void run() {
                MergeSort.sort(a);
                latch.countDown();
            }

        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                MergeSort.sort(b);
                latch.countDown();
            }
        }).start();

        //等待
        latch.await();

        //合并两个有序序列
        merge(a, b, array);

    }

    //合并序列
    private static void merge(int[] a1, int[] a2, int[] tmpArray) {
        int length1 = a1.length;
        int length2 = a2.length;

        int left = 0;
        int right = 0;
        int pos = 0;

        while (left < length1 && right < length2) {
            if (a1[left] <= a2[right]) {
                tmpArray[pos] = a1[left];
                left++;
            } else {
                tmpArray[pos] = a2[right];
                right++;
            }
            pos++;
        }

        while (left < length1) {
            tmpArray[pos++] = a1[left++];
        }

        while (right < length2) {
            tmpArray[pos++] = a2[right++];
        }

    }
}
