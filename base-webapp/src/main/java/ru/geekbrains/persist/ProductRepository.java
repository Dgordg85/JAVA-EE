package ru.geekbrains.persist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private final Connection conn;

    public ProductRepository(Connection conn) throws SQLException {
        this.conn = conn;
        createTableIfNotExist(conn);
    }


    public void insert(Product product) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO products('name', 'description', 'price') VALUES (?, ?, ?)")){
                stmt.setString(1, product.getName());
                stmt.setString(2, product.getDescription());
                stmt.setBigDecimal(3, product.getPrice());
                stmt.execute();
        }
    }

    public void update(Product product) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "UPDATE products SET 'name'= ?, 'description' = ?, 'price' = ? WHERE 'id' = ?;")){
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setBigDecimal(3, product.getPrice());
            stmt.setLong(4, product.getId());
            stmt.execute();
        }
    }

    public void delete(long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "DELETE FROM products WHERE  id = ?")){
            stmt.setLong(1, id);
            stmt.execute();
        }
    }

    public Product findById(long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM products WHERE  id = ?")){
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                return new Product(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4));
            }
        }
        return new Product(-1L, "", "", null);
    }

    public List<Product> findAll() throws SQLException{
        List<Product> res = new ArrayList<>();
        try(Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");

            while (rs.next()){
                res.add(new Product(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4)));
            }

        }
        return res;
    }


    private void createTableIfNotExist(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()){
            stmt.execute("CREATE TABLE IF NOT EXISTS products (\n" +
                    "    id          INTEGER         PRIMARY KEY AUTOINCREMENT,\n" +
                    "    name        VARCHAR (25),\n" +
                    "    description VARCHAR (25),\n" +
                    "    price       DECIMAL (19, 2) \n" +
                    ");");
        }
    }
}
