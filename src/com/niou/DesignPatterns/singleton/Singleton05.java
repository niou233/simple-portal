package com.niou.DesignPatterns.singleton;

/**
 * <pre>
 * @ClassName Singleton.java
 * 懒汉模式+加锁+静态内部类
 * JVM加载class只加载一次，保证了线程安全，但是可反序列化
 * </pre>
 *
 * @author 董珊珊<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/07/10 13:00<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/07/10 	董珊珊		    		新建
 * </pre>
 */
public class Singleton05 {
    private Singleton05() {

    }
    private static  class SingletonHolder {
        private static final Singleton05 INSTANCE = new Singleton05();
    }
    public static synchronized Singleton05 getInstance() {

        return  SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            new Thread(() -> System.out.println(Singleton05.getInstance().hashCode())).start();
        }
    }
}
