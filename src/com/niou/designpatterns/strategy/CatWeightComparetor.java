package com.niou.designpatterns.strategy;

import java.util.Comparator;

/**
 * <pre>
 * @ClassName CatComparetor.java
 * </pre>
 *
 * @author niou<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/07/10 14:52<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/07/10 	niou		    		新建
 * </pre>
 */
public class CatWeightComparetor implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.getWeight() < o2.getWeight()) return -1;
        else if (o1.getWeight() > o2.getWeight()) return 1;
        else return 0;
    }
}
