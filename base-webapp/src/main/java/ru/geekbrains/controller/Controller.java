package ru.geekbrains.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controller", urlPatterns = {"", "main", "catalog", "product", "cart", "order", "company", "addproduct"})
public class Controller extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        String url = "/WEB-INF/";

        String path = request.getServletPath();

        switch (path){
            case "/":
            case "/main": url += "index.jsp";
                break;
            case "/catalog": url += "catalog.jsp";
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

        request.getRequestDispatcher(url).forward(request, response);
    }
}
