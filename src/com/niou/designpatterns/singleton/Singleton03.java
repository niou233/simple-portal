package com.niou.designpatterns.singleton;

/**
 * <pre>
 * @ClassName Singleton.java
 * 懒汉模式+加锁
 * 效率低
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
public class Singleton03 {
    private  static Singleton03 INSTANCE = null;
    private Singleton03() {

    }

    public static synchronized Singleton03 getInstance() {
        if(INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton03();
        }
        return  INSTANCE;
    }

    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            new Thread(() -> System.out.println(Singleton03.getInstance().hashCode())).start();
        }
    }
}
