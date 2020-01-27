package ru.geekbrains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Main extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(Main.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New GET request from Main");
        resp.getWriter().println("" +
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>Главная страница</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Главная страница</h1>\n" +
                "</body>\n" +
                "</html>");
    }
}
