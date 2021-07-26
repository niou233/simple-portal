package com.niou.designpatterns.filterChain02;

import com.niou.designpatterns.filterChain.Request;
import com.niou.designpatterns.filterChain.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * @ClassName fitlerChain.java
 * servlet的filter、struts2的拦截器、spring-mvc的拦截器应用
 * </pre>
 *
 * @author niou<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/07/10 18:02<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/07/10 	niou		    		新建
 * </pre>
 */
public class FilterChain implements Filter {
    List<Filter> list = new ArrayList<>();
    int index = 0;

    public List<Filter> add(Filter filter){
        list.add(filter);
        return list;
    }
    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        if(index >= list.size()) {
            return false;
        }
        Filter filter = list.get(index);
        index++;
        return filter.doFilter(request, response, chain);
    }
}
