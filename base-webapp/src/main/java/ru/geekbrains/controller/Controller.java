package ru.geekbrains.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controller", urlPatterns = {"", "main", "product", "cart", "order", "company", "addproduct"})
public class Controller extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        String url = "/WEB-INF/";
        String path = req.getServletPath();

        switch (path){
            case "/":
            case "/main": url += "index.jsp";
                break;
            case "/product": url += "product.jsp";
                break;
            case "/cart": url += "cart.jsp";
                break;
            case "/order": url += "order.jsp";
                break;
            case "/company": url += "company.jsp";
                break;
            case "/addproduct": url += "addproduct.jsp";
        }

        req.getRequestDispatcher(url).forward(req, resp);
    }
}
