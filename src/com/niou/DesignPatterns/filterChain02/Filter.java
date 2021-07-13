package com.niou.DesignPatterns.filterChain02;

import com.niou.DesignPatterns.filterChain.Request;
import com.niou.DesignPatterns.filterChain.Response;

/**
 * @Description:
 * @Auther: Niou
 * @Date: 2021/7/10 18:02
 */
public interface Filter {
    public boolean doFilter(Request request, Response response, FilterChain chain);
}
