package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@WebServlet(name = "ProductController", urlPatterns = {"catalog", "create", "edit", "update", "delete"})
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        try {
            String path = req.getServletPath();

            switch (path){
                case "/catalog":
                    req.setAttribute("products", productRepository.findAll());
                    getServletContext().getRequestDispatcher("/WEB-INF/catalog.jsp").forward(req, resp);
                    break;
                case "/create":
                    showCreateProductPage(req, resp);
                    break;
                case "/edit":
                    showEditProductPage(req, resp);
                    break;
                case "/delete":
                    deleteProduct(req, resp);
                    break;
            }
        } catch (SQLException e) {
            logger.error("", e);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        switch (path){
            case "/update":
                updateProduct(req, resp);
                break;
            case "/create":
                createProduct(req, resp);
                break;
            default:
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            productRepository.insert(new Product(
                    -1L,
                    req.getParameter("name"),
                    req.getParameter("description"),
                    new BigDecimal(req.getParameter("price"))
            ));
            resp.sendRedirect(getServletContext().getContextPath() + "/catalog");
        } catch (SQLException ex) {
            logger.error("", ex);
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (NumberFormatException ex){
            logger.error("", ex);
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            productRepository.update(new Product(
                    Long.parseLong(req.getParameter("id")),
                    req.getParameter("name"),
                    req.getParameter("description"),
                    new BigDecimal(req.getParameter("price"))
            ));
            resp.sendRedirect(getServletContext().getContextPath() + "/catalog");
        } catch (SQLException ex) {
            logger.error("", ex);
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (NumberFormatException ex){
            logger.error("", ex);
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id;
        try{
            id = Long.parseLong(req.getParameter("id"));
            productRepository.delete(id);
            resp.sendRedirect(getServletContext().getContextPath() + "/catalog");
        } catch (NumberFormatException ex){
            logger.error("", ex);
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (SQLException ex){
            logger.error("", ex);
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

    }


    private void showCreateProductPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("product", new Product());
        req.setAttribute("action", "create");
        getServletContext().getRequestDispatcher("/WEB-INF/product.jsp").forward(req, resp);
    }


    private void showEditProductPage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (Exception ex){
            logger.error("", ex);
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Product product;
        try {
            product = productRepository.findById(id);
        } catch (SQLException ex) {
            logger.error("", ex);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        req.setAttribute("product", product);
        req.setAttribute("action", "update");
        getServletContext().getRequestDispatcher("/WEB-INF/product.jsp").forward(req, resp);

    }


}
