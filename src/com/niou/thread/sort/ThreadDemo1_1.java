package com.niou.thread.sort;

/**
 * <pre>
 * @ClassName ThreadDemo1_1.java
 * </pre>
 *
 * @author Niou<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/06/26 18:54<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/06/26 	Niou		    		新建
 * </pre>
 */
public class ThreadDemo1_1 {
    /**
     * 对数组求和
     *
     * @param array       数组
     * @param threadCount 线程数
     * @return 数组元素和
     */
    public long sumArray(final int[] array, int threadCount) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("数组长度必须大于0");
        }

        final RuntimeSave rd = new RuntimeSave();     // 保存数据
        final int lenPerThread = array.length / threadCount;  // 计算每个线程的数组元素个数

        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            new Thread() {
                @Override
                public void run() {
                    long s = 0;
                    int start = index * lenPerThread;
                    int end = start + lenPerThread;

                    for (int j = start; j < end; j++) {
                        s += array[j];
                    }
                    synchronized (rd) {
                        rd.sum += s;
                        rd.finishThreadCount++;
                    }
                }

                ;
            }.start();
        }

        int remain = array.length % threadCount;      // 剩余数组元素
        long s = 0;

        for (int i = array.length - remain; i < array.length; i++) {
            s += array[i];
        }
        synchronized (rd) {
            rd.sum += s;
        }

        while (rd.finishThreadCount != threadCount) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
        return rd.sum;
    }

    /**
     * 保存运行时的相关数据
     *
     * @author adamjwh
     */
    static class RuntimeSave {
        long sum;  // 保存求和
        int finishThreadCount;  // 已执行完毕的线程数
    }
}
