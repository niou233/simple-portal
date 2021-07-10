package com.niou.thread.sort;

/**
 * <pre>
 * @ClassName MainEx2_5.java
 * </pre>
 *
 * @author Niou<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/06/26 18:53<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/06/26 	Niou		    		新建
 * </pre>
 */
public class MainEx2_5 {
    private static int[] array = new MakeArrays().makeArray();

    /**
     * 测试函数
     *
     * @param args ms : currentTimeMillis
     *             ns : nanoTime
     */
    public static void main(String[] args) {
        /**
         * 串行测试
         */
        long startTime = System.currentTimeMillis();   //获取开始时间
        new SerialDemo().mergeSort(array);  //测试的代码段
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("串行使用的时间： " + (endTime - startTime) + "ms");

        /**
         * 线程测试
         */
        long startTime1 = System.currentTimeMillis();   //获取开始时间
        try {
            new ThreadDemo2_5().mergeSort(array);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //测试的代码段
        long endTime1 = System.currentTimeMillis(); //获取结束时间
        System.out.println("线程使用的时间： " + (endTime1 - startTime1) + "ms");

        long startTime3 = System.currentTimeMillis();   //获取开始时间
        new ThreadDemo1_1().sumArray(array, 100);
        long endTime3 = System.currentTimeMillis(); //获取结束时间
        System.out.println("线程使用的时间： " + (endTime3 - startTime3) + "ms");
    }
}
