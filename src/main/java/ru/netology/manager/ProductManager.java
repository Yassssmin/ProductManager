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
            if (item.matches(text)) {
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
}

