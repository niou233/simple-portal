package com.niou.designpatterns.singleton;

/**
 * <pre>
 * @ClassName Singleton.java
 * 饿汉模式
 * Class.forName("")
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
public class Singleton {
    private  static  final Singleton INSTANCE = new Singleton();
    private Singleton() {

    }

    public static Singleton getInstance() {
        return  Singleton.INSTANCE;
    }

    public static void main(String[] args) {

    }
}
