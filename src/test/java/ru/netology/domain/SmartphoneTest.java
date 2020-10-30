package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    Smartphone smartphone;

    @BeforeEach
    void setUp() {
        smartphone = new Smartphone(1,"Test", 100,"Apple");
    }

    @Test
    void shouldMatchedByRightName() {
        assertTrue(smartphone.matches("Test"));
    }

    @Test
    void shouldNotMatchedByWrongName() {
        assertFalse(smartphone.matches("Wrong"));
    }

    @Test
    void shouldMatchedByRightManufacturer() {
        assertTrue(smartphone.matches("Apple"));
    }

    @Test
    void shouldNotMatchedByWrongManufacturer() {
        assertFalse(smartphone.matches("Wrong"));
    }
}