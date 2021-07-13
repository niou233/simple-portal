package com.niou.DesignPatterns.singleton;

import com.niou.DesignPatterns.singleton.Singleton;

/**
 * <pre>
 * @ClassName Main.java
 * </pre>
 *
 * @author 董珊珊<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/07/10 13:03<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/07/10 	董珊珊		    		新建
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        Singleton sg1 = Singleton.getInstance();
        Singleton sg2 = Singleton.getInstance();
        System.out.println(sg1 == sg2);
    }
}
