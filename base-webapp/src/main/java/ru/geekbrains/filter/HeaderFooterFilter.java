package ru.geekbrains.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "HeaderFooterFilter", urlPatterns = "/*")
public class HeaderFooterFilter implements Filter {

    private FilterConfig config;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        resp.getWriter().println("<h1>Header from filter</h1>");
        chain.doFilter(req, resp);
        resp.getWriter().println("<h1>Footer from filter</h1>");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

        this.config = config;
    }

    @Override
    public void destroy() {

    }
}
