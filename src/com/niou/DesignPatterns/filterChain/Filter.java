package com.niou.DesignPatterns.filterChain;

/**
 * @Description:
 * @Auther: Niou
 * @Date: 2021/7/10 18:02
 */
public interface Filter {
    public boolean doFilter(Request request, Response response);
}
