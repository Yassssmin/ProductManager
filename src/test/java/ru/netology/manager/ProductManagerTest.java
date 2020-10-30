package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    void shouldSearchProductByName() {
        Product firstProduct = new Product(1,"First", 100);
        Product secondProduct = new Product(2,"Second", 200);
        Product thirdProduct = new Product(3,"Third", 300);

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(firstProduct);
        manager.add(secondProduct);
        manager.add(thirdProduct);

        Product[] expected = new Product[]{secondProduct};
        Product[] actual = manager.searchBy("Second");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByName() {
        Book firstBook = new Book(1,"First", 100,"FirstAuthor");
        Book secondBook = new Book(2,"Second", 200,"SecondAuthor");
        Book thirdBook = new Book(3,"Third", 300,"ThirdAuthor");

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);

        Product[] expected = new Product[]{firstBook};
        Product[] actual = manager.searchBy("First");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByName() {
        Smartphone firstSmartphone = new Smartphone(1,"First", 100,"Apple");
        Smartphone secondSmartphone = new Smartphone(2,"Second", 200,"Samsung");
        Smartphone thirdSmartphone = new Smartphone(3,"Third", 300,"Xaomi");

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
        manager.add(thirdSmartphone);

        Product[] expected = new Product[]{thirdSmartphone};
        Product[] actual = manager.searchBy("Third");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByManufacturer() {
        Smartphone firstSmartphone = new Smartphone(1,"First", 100,"Apple");
        Smartphone secondSmartphone = new Smartphone(2,"Second", 200,"Samsung");
        Smartphone thirdSmartphone = new Smartphone(3,"Third", 300,"Xaomi");

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
        manager.add(thirdSmartphone);

        Product[] expected = new Product[]{secondSmartphone};
        Product[] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByAuthor() {
        Book firstBook = new Book(1,"First", 100,"FirstAuthor");
        Book secondBook = new Book(2,"Second", 200,"SecondAuthor");
        Book thirdBook = new Book(3,"Third", 300,"ThirdAuthor");

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);

        Product[] expected = new Product[]{thirdBook};
        Product[] actual = manager.searchBy("ThirdAuthor");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchProductByNameWithEmptyRepository() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Second");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchProductByNameAmongOneElement() {
        Product product = new Product(3,"Test", 300);

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(product);

        Product[] expected = new Product[]{product};
        Product[] actual = manager.searchBy("Test");

        assertArrayEquals(expected, actual);
    }
}