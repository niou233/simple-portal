package com.niou.designpatterns.proxy.v2;

/**
 * <pre>
 * @ClassName Main.java
 * 静态代理
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
        Bus bus = new Bus();
        Taxi taxi = new Taxi();
        MaleDriver proxy1 = new MaleDriver(bus);
        proxy1.move();
        proxy1.setMovable(taxi);
        proxy1.move();
    }
}

interface Movable {
    void move();
}
class Bus implements  Movable {
    @Override
    public void move() {
        System.out.println("bus running");
    }
}
class Taxi implements  Movable {
    @Override
    public void move() {
        System.out.println("taxi wait for a gust to run");
    }
}
class MaleDriver implements Movable {
    private Movable movable;

    public MaleDriver(Movable movable) {
        this.movable = movable;
    }

    public void setMovable(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        System.out.println("check the steer wheel");
        movable.move();
        System.out.println("check the rearview mirror");
    }
}