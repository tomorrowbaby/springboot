package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Filter过滤器
 * @author 王玉
 * @date 2019/3/10
 */
@WebFilter(filterName = "UserFilter", value = "/*")
public class UserFilter implements Filter {
    //初始化方法只在容器开始时候执行一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init被执行");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter被执行");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    //销毁方法也只在Filter的生命周期结束是执行一次
    @Override
    public void destroy() {
        System.out.println("destroy被执行");
    }
}
