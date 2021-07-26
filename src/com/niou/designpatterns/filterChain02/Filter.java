package com.niou.designpatterns.filterChain02;

import com.niou.designpatterns.filterChain.Request;
import com.niou.designpatterns.filterChain.Response;

/**
 * @Description:
 * @Auther: Niou
 * @Date: 2021/7/10 18:02
 */
public interface Filter {
    public boolean doFilter(Request request, Response response, FilterChain chain);
}
