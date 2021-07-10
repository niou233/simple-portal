package com.niou.thread;

/**
 * <pre>
 * @ClassName ThreadSafeTest.java
 * </pre>
 *
 * @author Niou<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/06/26 18:33<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/06/26 	Niou		    		新建
 * </pre>
 */
public class ThreadSafeTest implements  Runnable {
    private static  int num = 10;
    @Override
    public void run() {
        synchronized (""){
            while ( num > 0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("车票剩余：" + num-- + "张");
            }
        }
    }

    public static void main(String[] args) {
        ThreadSafeTest test = new ThreadSafeTest();
        Thread mythread1 = new Thread(test);
        Thread mythread2 = new Thread(test);
        Thread mythread3 = new Thread(test);
        mythread1.start();
        mythread2.start();
        mythread3.start();

    }
}
