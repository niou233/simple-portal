package com.niou.thread.sort;

import java.util.Random;

/**
 * <pre>
 * @ClassName MakeArrays.java
 * </pre>
 *
 * @author Niou<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/06/26 18:42<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/06/26 	Niou		    		新建
 * </pre>
 */
public class MakeArrays {
    private int length = 1024*1024;

    public int[] makeArray() {
        int[] array = new int[length];

        Random random = new Random();
        for(int i=0; i<length; i++) {
            int x = random.nextInt();
            array[i] = x;
        }

        return array;
    }
}
