package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;
import ru.netology.repository.NegativeIdException;

import static org.junit.jupiter.api.Assertions.assertThrows;

import ru.netology.repository.AlreadyExistsException;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();


    Product product1 = new Book(1, "Crime and Punishment", 345, "Dostoevsky");
    Product product2 = new Smartphone(2, "Galaxy", 24567, "Samsung");
    Product product3 = new Book(3, "For whom the Bell Tolls", 567, "Hemingway");
    Product product4 = new Smartphone(4, "Iphone", 45897, "Apple");
    Product product5 = new Smartphone(4, "IphoneX", 120000, "Apple");
    
    @Test
    public void removeByIdTest() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.removeById(1);
        Product[] actual = repo.findAll();
        Product[] expected = {product2, product3, product4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void NegativeIdExceptionTest() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        assertThrows(NegativeIdException.class, () -> {
            repo.removeById(7);

        });
    }

    @Test
    public void addTest() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void AlreadyExistsExceptionTest() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product5);

        });
    }
}
