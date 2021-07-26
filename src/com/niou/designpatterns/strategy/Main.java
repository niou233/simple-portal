package com.niou.designpatterns.strategy;

import com.niou.sort.BubbleSort;

import java.util.Arrays;

/**
 * <pre>
 * @ClassName Main.java
 * </pre>
 *
 * @author niou<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/07/10 14:16<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/07/10 	niou		    		新建
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        int a[] = {3, 5, 2, 7, 4, 9, 1};
        Cat[] c = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};
        Dog[] d = {new Dog(7), new Dog(4), new Dog(3)};
        BubbleSort.sort(a);
        Sort<Cat> mysort = new Sort<>();
        mysort.sort(c, new CatWeightComparetor());
//        Sort.sort(d);
        System.out.println(a);
        System.out.println(Arrays.toString(c));
        mysort.sort(c, new CatHeightComparetor());
        System.out.println(Arrays.toString(d));
        mysort.sort(c, (o1, o2) -> {
            if(o1.getWeight() < o1.getWeight()) return -1;
            else if(o1.getWeight() > o1.getWeight())return 1;
            else return 0;
        });
        System.out.println(Arrays.toString(d));
    }
}
