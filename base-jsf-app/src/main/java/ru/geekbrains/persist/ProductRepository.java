package ru.geekbrains.persist;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductRepository {

    void insert(Product product);

    void update(Product product);

    void delete(long id);

    List<Product> findAll();
}
