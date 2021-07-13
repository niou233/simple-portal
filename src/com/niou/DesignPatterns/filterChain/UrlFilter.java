package com.niou.DesignPatterns.filterChain;

/**
 * <pre>
 * @ClassName UrlFilter.java
 * </pre>
 *
 * @author 董珊珊<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/07/10 18:06<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/07/10 	董珊珊		    		新建
 * </pre>
 */
public class UrlFilter implements  Filter {
    @Override
    public boolean doFilter(Request request, Response response) {
        System.out.println("do url filter request");
        request.setUri(request.getUri() + "->UrlFilter()");

        System.out.println("do url filter response");
        response.setMsg(response.getMsg() + "->UrlFilter()");
        return true;
    }
}
