package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    Book book;

    @BeforeEach
    void setUp() {
        book = new Book(1,"Test", 100,"Author");
    }

    @Test
    void shouldMatchedByRightName() {
        assertTrue(book.matches("Test"));
    }

    @Test
    void shouldNotMatchedByWrongName() {
        assertFalse(book.matches("Wrong"));
    }

    @Test
    void shouldMatchedByRightAuthor() {
        assertTrue(book.matches("Author"));
    }

    @Test
    void shouldNotMatchedByWrongAuthor() {
        assertFalse(book.matches("Wrong"));
    }
}