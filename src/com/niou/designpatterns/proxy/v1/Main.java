package com.niou.designpatterns.proxy.v1;

/**
 * <pre>
 * @ClassName Main.java
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
        MaleDriver proxy1 = new MaleDriver();
        proxy1.move();
        FemaleDriver proxy2 = new FemaleDriver();
        proxy2.move();
    }
}

interface Movable {
    abstract void move();
}

class car implements Movable {
    @Override
    public void move() {
        System.out.println("run run run away");
    }
}

class MaleDriver extends car {
    @Override
    public void move() {
        System.out.println("check the steer wheel");
        super.move();
        System.out.println("check the rearview mirror");
    }
}

class  FemaleDriver extends car {
    @Override
    public void move() {
        System.out.println("step on the gas");
        super.move();
        System.out.println("slam the brakes");
    }
}