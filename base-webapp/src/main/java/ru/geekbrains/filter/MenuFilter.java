package ru.geekbrains.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "MenuFilter", urlPatterns = "/*")
public class MenuFilter implements Filter {

    private transient FilterConfig config;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        res.setCharacterEncoding("utf-8");
        res.setContentType("text/html");
        chain.doFilter(req, res);
        config.getServletContext().getRequestDispatcher("/WEB-INF/menu.html").include(req, res);


    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }
}
