package com.niou.designpatterns.observer.v2;

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
public class v2Main {
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

    public Children(boolean cry) {
        this.cry = cry;
    }

    public boolean isCry(){
        return  this.cry;
    }
    public void wakeUp(){
        this.cry = true;
        System.out.println("children wake up");
    }
}
