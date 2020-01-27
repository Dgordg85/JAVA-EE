package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProductController", urlPatterns = "catalog")
public class ProductController extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        this.productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");

        if (productRepository == null){
            throw new ServletException("ProductRepository not created");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        try {
            req.setAttribute("products", productRepository.findAll());
            getServletContext().getRequestDispatcher("/WEB-INF/catalog.jsp").forward(req, resp);

        } catch (SQLException e) {
            logger.error("", e);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }


    }
}
