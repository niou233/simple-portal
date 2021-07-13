package com.niou.DesignPatterns.singleton;

/**
 * <pre>
 * @ClassName Singleton.java
 * 枚举单利
 * 解决了线程同步问题，还可以防止反序列化,防止通过反射实例化（因为没有构造方法）
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
public enum Singleton06 {
    INSTANCE;

    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            new Thread(() -> System.out.println(Singleton06.INSTANCE.hashCode())).start();
        }
    }
}
