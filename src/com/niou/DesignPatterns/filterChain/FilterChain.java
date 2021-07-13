package com.niou.DesignPatterns.filterChain;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * @ClassName fitlerChain.java
 * </pre>
 *
 * @author 董珊珊<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/07/10 18:02<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/07/10 	董珊珊		    		新建
 * </pre>
 */
public class FilterChain implements  Filter {
    List<Filter> list = new ArrayList<>();
    public List<Filter> add(Filter filter){
        list.add(filter);
        return list;
    }
    @Override
    public boolean doFilter(Request request, Response response) {
        for (Filter f: list){
            f.doFilter(request, response);
        }

        return true;
    }

}
