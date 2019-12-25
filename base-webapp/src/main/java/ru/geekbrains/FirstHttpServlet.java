package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// URL mapping patterns

// /something   -> /something
// /something/* -> /something/ /something/sfsd
// *.jpg        -> "/something/asdasd/filename.jpg"
// ""           -> application root
// "/"          -> all application URLs
// "/*"         ->  !!!Antipattern!!!

@WebServlet(name = "FirstHttpServlet", urlPatterns = "/httpservlet/*")
public class FirstHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Hello from HTTP servlet!</h1>");
        resp.getWriter().println("<p>contextPath: " + req.getContextPath() + "</p>");
        resp.getWriter().println("<p>getServletPass: " + req.getServletPath() + "</p>");
        resp.getWriter().println("<p>getPathInfo: " + req.getPathInfo() + "</p>");
        resp.getWriter().println("<p>getQueryString: " + req.getQueryString() + "</p>");

        //req.getRequestDispatcher("/helloworld").include(req, resp);
        getServletContext().getRequestDispatcher("/helloworld").include(req, resp);
        //resp.sendRedirect("http://ya.ru");
    }
}
