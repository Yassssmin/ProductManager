package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product;

    @BeforeEach
    void setUp() {
        product = new Product(1,"Test", 100);
    }

    @Test
    void shouldMatchedByRightName() {
        assertTrue(product.matches("Test"));
    }

    @Test
    void shouldNotMatchedByWrongName() {
        assertFalse(product.matches("Wrong"));
    }
}