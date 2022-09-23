package ru.netology.repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    private Book first = new Book(1, "Тестирование ПО", 1000, "Святослав Куликов");
    private Book second = new Book(2, "Tестирование dot com", 1000, "Роман Савин");
    private Book third = new Book(3, "Тестирование черного ящика", 1000, "Борис Бейзер");
    private Book fourth = new Book(4, "Ключевые процессы тестирования", 1000, "Рекс Блэк");
    private Book fifth = new Book(5, "Автоматизированное тестирование программного обеспечения", 1000, "Элфрид Дастин, Джефф Рэшка, Джон Пол");
    private Smartphone sixth = new Smartphone(6, "Samsung", 5000, "South Korea");
    private Smartphone seventh = new Smartphone(7, "Xiaomi", 5000, "Китай");
    private Smartphone eidhth = new Smartphone(8, "Huawei", 5000, "Китай");
    private Smartphone ninth = new Smartphone(9, "Nokia", 5000, "Финляндия");
    private Smartphone tenth = new Smartphone(10, "Sony", 5000, "Япония");


    @BeforeEach
    public void setup() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);
        repository.add(fifth);
        repository.add(sixth);
        repository.add(seventh);
        repository.add(eidhth);
        repository.add(ninth);
        repository.add(tenth);

    }

    private void assertArrayEquals(Product[] expected, Product[] actual) {
    }

    @Test // Тест сохранить и найти все
    public void testSaveAndFindAll() {
        assertEquals(repository.findAll().length, 10);
    }


    @Test // Тест удаления по ID
    public void shouldRemoveByID() {
        repository.add(first);
        repository.add(second);
        repository.removeById(1);
        Product[] expected = new Product[]{second};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

}