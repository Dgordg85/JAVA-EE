package ru.geekbrains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Catalog", urlPatterns = "/catalog")
public class Catalog extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(Catalog.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New GET request from Catalog");
        getServletContext().getRequestDispatcher("/catalog.jsp").forward(req, resp);
    }
}
