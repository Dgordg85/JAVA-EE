package ru.geekbrains;

import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepositoryRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Future;

public class EjbClient {

    public static void main(String[] args) throws Exception {
        Context context = createInitialContext();

        ProductRepositoryRemote repository = (ProductRepositoryRemote)context.lookup("ejb:/base-jsf-app/ProductRepositoryImpl!ru.geekbrains.persist.ProductRepositoryRemote");
        repository.findAll().forEach(prod-> System.out.println(prod.getName()));

        Future<List<Product>> future = repository.findAllAsync();
        System.out.println("Waiting for completion");
        future.get().forEach(product -> System.out.println(product.getName()));

    }

    public static Context createInitialContext() throws IOException, NamingException {
        final Properties env = new Properties();
        env.load(EjbClient.class
                .getClassLoader()
                .getResourceAsStream("wildfly-jndi.properties"));
        return new InitialContext(env);
    }
}
