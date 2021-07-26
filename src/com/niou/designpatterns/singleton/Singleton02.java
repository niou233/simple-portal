package com.niou.designpatterns.singleton;

/**
 * <pre>
 * @ClassName Singleton.java
 * 懒汉模式
 * 多线程访问安全问题：可能访问的不是同一个实例
 * </pre>
 *
 * @author niou<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/07/10 13:00<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/07/10 	niou		    		新建
 * </pre>
 */
public class Singleton02 {
    private  static Singleton02 INSTANCE = null;
    private Singleton02() {

    }

    public static Singleton02 getInstance() {
        if(INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton02();
        }
        return  INSTANCE;
    }

    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            new Thread(() -> System.out.println(Singleton02.getInstance().hashCode())).start();
        }
    }
}
