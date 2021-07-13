package com.niou.DesignPatterns.Observer.v4;

/**
 * <pre>
 * @ClassName v1Main.java
 * 耦合高
 * </pre>
 *
 * @author 董珊珊<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/07/12 23:03<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/07/12 	董珊珊		    		新建
 * </pre>
 */
public class v4Main {
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
    Dad dad = new Dad();
    Mum mum = new Mum();
    Dog dog = new Dog();
    public Children(boolean cry) {
        this.cry = cry;
    }

    public boolean isCry(){
        return  this.cry;
    }
    public void wakeUp(){
        this.cry = true;
        System.out.println("children wake up");
        dad.feed();
        mum.hug();
        dog.wang();
    }
}

class  Dad {
    public void feed() {
        System.out.println("dad come to feed");
    }
}

class  Mum {
    public void hug() {
        System.out.println("mum come to feed");
    }
}

class  Dog {
    public void wang() {
        System.out.println("dog wan wan");
    }
}