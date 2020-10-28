package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;


public class ProductManager {
    private ProductRepository productRepository;

    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void add(Product product) {
        this.productRepository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] products = this.productRepository.getAll();

        Product[] searchResult = new Product[0];

        for (Product item : products) {
            if (this.matches(item, text)) {
                int length = searchResult.length + 1;
                Product[] tmp = new Product[length];

                System.arraycopy(searchResult, 0, tmp, 0, searchResult.length);

                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = item;

                searchResult = tmp;
            }
        }

        return searchResult;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;

            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }

            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }

            return false;
        } else if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;

            if (smartphone.getName().equalsIgnoreCase(search)) {
                return true;
            }

            if (smartphone.getManufacturer().equalsIgnoreCase(search)) {
                return true;
            }

            return false;
        } else {
            if (product.getName().equalsIgnoreCase(search)) {
                return true;
            }

            return false;
        }
    }
}

