package com.niou.designpatterns.singleton;

/**
 * <pre>
 * @ClassName Singleton.java
 * 懒汉模式+加锁+双重检查
 * 代码复杂度增加
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
public class Singleton04 {
    private  static volatile Singleton04 INSTANCE = null; // JIT优化会进行重排；volidate直接将数据刷新到主内存，不会重排
    private Singleton04() {

    }

    /**
     *  没有使用volidate修饰变量，会出现重排 1-2-3 排序为 1-3-2
     *  多线程访问会出现问题
     *  例如现在有2个线程A,B
     *  线程A在执行第5行代码时，B线程进来，而此时A执行了 1和3，没有执行2，此时B线程判断instance不为null 直接返回一个未初始化的对象，就会出现问题
     *
     * volidate解决 1、线程间可见；2、禁止重排序
     */
    public static synchronized Singleton04 getInstance() { //1
        if(INSTANCE == null) { //2
            synchronized (Singleton04.class) { //3
                if(INSTANCE == null) { //4
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton04(); //5
                }
            }
        }
        return  INSTANCE;
    }

    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            new Thread(() -> System.out.println(Singleton04.getInstance().hashCode())).start();
        }
    }
}
