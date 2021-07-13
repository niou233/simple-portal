package com.niou.DesignPatterns.strategy;

/**
 * <pre>
 * @ClassName Dog.java
 * </pre>
 *
 * @author 董珊珊<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/07/10 14:34<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/07/10 	董珊珊		    		新建
 * </pre>
 */
public class Dog implements Comparable<Dog>{
    int food;
    public Dog(int f) {
        this.food = f;
    }

    public int getFood() {
        return food;
    }

    @Override
    public int compareTo(Dog o) {
        if(this.food < o.getFood())return -1;
        else if(this.food > o.getFood()) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
