package com.niou.designpatterns.observer.v6;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * @ClassName v1Main.java
 * 源对象 观察者 事件
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
public class v6Main {
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
        WakeUpEvent event = new WakeUpEvent(100, "bed");
        for (Observer o : list){
            o.actionToWakeUp(event);
        }
    }
}
class WakeUpEvent {
    long timestamp;
    String loc;

    public WakeUpEvent(long timestamp, String loud) {
        this.timestamp = timestamp;
        this.loc = loud;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getLoud() {
        return loc;
    }

    public void setLoud(String loud) {
        this.loc = loud;
    }
}
interface  Observer {
    void actionToWakeUp(WakeUpEvent event);
}

class  Dad implements Observer {
    public void feed() {
        System.out.println("dad come to feed");
    }

    @Override
    public void actionToWakeUp(WakeUpEvent event) {
        feed();
    }
}

class  Mum implements Observer {
    @Override
    public void actionToWakeUp(WakeUpEvent event) {
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
    public void actionToWakeUp(WakeUpEvent event) {
        wang();
    }
}