package ru.geekbrains.controller;

import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named
public class ProductController implements Serializable {

    @Inject
    private ProductRepository productRepository;

    @Inject
    private BasketController basketController;

    private Product product;

    public String createProduct(){
        this.product = new Product();
        return "/product.xhtml?faces-redirect=true";
    }


    public List<Product> getAllProducts() throws SQLException {
        return productRepository.findAll();
    }

    public String editProduct(Product product) {
        this.product = product;
        return "/product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(Product product) throws SQLException {
        this.product = product;
        productRepository.delete(this.product.getId());
        //return "/index.xhtml?faces-redirect=true";
    }

    public void addToBasket(Product product) {
       basketController.addProductToBasket(product);
    }

    public String saveProduct() throws SQLException {
        if (product.getId() == null){
            productRepository.insert(product);
        } else {
            productRepository.update(product);
        }
        return "/index.xhtml?faces-redirect=true";
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String goToBasket(){
        return "/basket.xhtml?faces-redirect=true";
    }

    public String goToIndex(){
        return "/index.xhtml?faces-redirect=true";
    }
}
