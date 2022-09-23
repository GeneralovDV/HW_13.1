package ru.netology.domain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {
    Product product = new Book(3, "Тестирование черного ящика", 1000, "Борис Бейзер");

    @Test
    public void shouldGetNameAndSetName() {
        String expected = "Тестирование черного ящика";
        product.setName(expected);
        assertEquals(expected, product.getName());
    }

    @Test
    public void shouldGetIDAndSetId() {
        product.setId(3);
        assertEquals(3, product.getId());
    }

}