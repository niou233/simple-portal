package com.niou.designpatterns.filterChain02;

import com.niou.designpatterns.filterChain.Request;
import com.niou.designpatterns.filterChain.Response;

/**
 * <pre>
 * @ClassName WordFilter.java
 * </pre>
 *
 * @author niou<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/07/10 18:09<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/07/10 	niou		    		新建
 * </pre>
 */
public class WordFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        System.out.println("do word filter request");
        request.getUri().replaceAll("<", "[");
        request.getUri().replaceAll(">", "]");
        request.setUri(request.getUri() + "->WordFilter()");
        chain.doFilter(request, response, chain);
        System.out.println("do word filter response");
        response.setMsg(response.getMsg() + "->WordFilter()");
        return true;
    }
}
