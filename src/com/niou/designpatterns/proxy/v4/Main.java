package com.niou.designpatterns.proxy.v4;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <pre>
 * @ClassName Main.java
 * cglib 代理类可以不用实现接口 底层使用asm
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
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Taxi.class);
        enhancer.setCallback(new MyMethodInterceptor());
        Taxi newTaxi = (Taxi) enhancer.create();
        newTaxi.move();
    }
}

class Taxi {
    public void move() {
        System.out.println("taxi wait for a gust to run");
    }
}

class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("check the steer wheel");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("check the rearview mirror");
        return result;
    }
}