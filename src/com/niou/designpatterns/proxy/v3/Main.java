package com.niou.designpatterns.proxy.v3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <pre>
 * @ClassName Main.java
 * reflection 反射代理  代理类必须实现接口 底层使用asm
 * </pre>
 *
 * @author niou<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/07/15 22:01<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/07/15 	niou		    		新建
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Movable movable = (Movable) Proxy.newProxyInstance(taxi.getClass().getClassLoader(),
                new Class[]{Movable.class},
                new MyInvocationHandler(taxi));
        movable.move();
    }
}

interface Movable {
    void move();
}

class Bus implements Movable {
    @Override
    public void move() {
        System.out.println("bus running");
    }
}

class Taxi implements Movable {
    @Override
    public void move() {
        System.out.println("taxi wait for a gust to run");
    }
}

class MyInvocationHandler implements  InvocationHandler {
    Movable car;

    public MyInvocationHandler(Movable car) {
        this.car = car;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("check the steer wheel");
        Object obj = method.invoke(car, args);
        System.out.println("check the rearview mirror");
        return obj;
    }
}