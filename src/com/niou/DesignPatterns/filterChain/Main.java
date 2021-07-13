package com.niou.DesignPatterns.filterChain;

/**
 * <pre>
 * @ClassName Main.java
 * </pre>
 *
 * @author 董珊珊<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/07/10 18:10<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/07/10 	董珊珊		    		新建
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        FilterChain chain = new FilterChain();
        chain.add(new UrlFilter()).add(new WordFilter());
        Request request = new Request("<html>欢迎访问 http://www.oracle.com/index.html</html>");
        Response response = new Response("");
        chain.doFilter(request, response);
        System.out.println(response.getMsg());
    }
}
