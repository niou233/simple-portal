package com.niou.thread;

/**
 * <pre>
 * @ClassName MyThread.java
 * </pre>
 *
 * @author Niou<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/06/26 18:09<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/06/26 	Niou		    		新建
 * </pre>
 */
public class MyThread extends Thread {
    private static  int i = 0;
    @Override
    public void run() {
        //super.run();
        i++;
        System.out.println(i);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread mythread1 = new MyThread();
        Thread mythread2 = new MyThread();
        Thread mythread3 = new MyThread();
        Thread mythread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                i += 10;
                System.out.println(i);
            }
        });
        mythread1.start();
        mythread4.start();
        mythread4.join();
        mythread2.start();
        mythread3.start();
    }
}
