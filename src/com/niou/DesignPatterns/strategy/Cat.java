package com.niou.DesignPatterns.strategy;

/**
 * <pre>
 * @ClassName Cat.java
 * </pre>
 *
 * @author 董珊珊<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/07/10 14:22<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/07/10 	董珊珊		    		新建
 * </pre>
 */
public class Cat implements Comparable<Cat>{
    private int weight;
    private int height;
    public Cat(int w, int h) {
        this.weight = w;
        this.height = h;
    }

    @Override
    public int compareTo(Cat cat2){
        if(this.weight < cat2.getWeight())   return -1;
        else if (this.weight < cat2.getWeight())  return 1;
        else  return 0;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
