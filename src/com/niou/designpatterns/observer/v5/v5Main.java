package com.niou.designpatterns.observer.v5;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * @ClassName v1Main.java
 * </pre>
 *
 * @author niou<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/07/12 23:03<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/07/12 	niou		    		新建
 * </pre>
 */
public class v5Main {
    public static void main(String[] args) {
        Children children = new Children(false);
        while (!children.isCry()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("do observer ...");
            children.wakeUp();
        }
    }
}

class Children {
    boolean cry = false;
    List<Observer> list = new ArrayList<>();
    {
        list.add(new Dad());
        list.add(new Mum());
        list.add(new Dog());
    }
    public Children(boolean cry) {
        this.cry = cry;
    }

    public boolean isCry(){
        return  this.cry;
    }
    public void wakeUp(){
        this.cry = true;
        System.out.println("children wake up");
        for (Observer o : list){
            o.actionToWakeUp();
        }
    }
}

interface  Observer {
    void actionToWakeUp();
}

class  Dad implements Observer {
    public void feed() {
        System.out.println("dad come to feed");
    }

    @Override
    public void actionToWakeUp() {
        feed();
    }
}

class  Mum implements Observer {
    @Override
    public void actionToWakeUp() {
        hug();
    }

    public void hug() {
        System.out.println("mum come to feed");
    }
}

class  Dog implements Observer {
    public void wang() {
        System.out.println("dog wan wan");
    }

    @Override
    public void actionToWakeUp() {
        wang();
    }
}