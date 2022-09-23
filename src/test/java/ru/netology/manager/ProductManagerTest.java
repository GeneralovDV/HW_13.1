package ru.netology.manager;
import com.sun.source.doctree.AuthorTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book first = new Book(1, "Тестирование ПО", 1000, "Святослав Куликов");
    Book second = new Book(2, "Tестирование dot com", 1000, "Роман Савин");
    Book third = new Book(3, "Тестирование черного ящика", 1000, "Борис Бейзер");
    Book fourth = new Book(3, "Тестирование черного ящика", 1000, "Борис Бейзер");
    Book fifth = new Book(5, "Автоматизированное тестирование программного обеспечения", 1000, "Элфрид Дастин, Джефф Рэшка, Джон Пол");
    Smartphone sixth = new Smartphone(6, "Samsung", 5000, "Южная Корея");
    Smartphone seventh = new Smartphone(7, "Xiaomi", 5000, "Китай");
    Smartphone eidhth = new Smartphone(8, "Huawei", 5000, "Китай");
    Smartphone ninth = new Smartphone(9, "Nokia", 5000, "Финляндия");
    Smartphone tenth = new Smartphone(10, "Sony", 5000, "Япония");


    @BeforeEach
    public void setup() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eidhth);

    }

    @Test
    void shouldSearchForSeveralProductsBook() {
        Product[] actual= manager.searchBy("Тестирование черного ящика");
        Product[]expected = new Product[]{third, fourth};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(expected));
    }


    @Test // Тест добавления еще одного элемента
    public void shouldAddOneMore() {
        manager.add(ninth);
        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{first, second, third, fourth, fifth, sixth, seventh, eidhth, ninth};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(actual));
    }

    @Test // Тест использование метода переопределения
    public void shouldEseOverridedMethod() {
        Product product = new Book();
        product.toString();
    }

    @Test // Тест сохранения всего списка
    void shouldGetAll() {
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, second,third, fourth, fifth, sixth, seventh, eidhth};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(actual));
    }


    @Test // Тест поик книги по названию
    public void shouldFindByBookName() {
        Product[] actual = manager.searchBy("Tестирование dot com");
        Product[] expected = new Product[]{second};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(actual));
    }

    @Test
        //Тест поиска книги по автору которой нет в списке
    void shouldFindAuthoNotExistBook() {
        manager.add(first);
        Product[] actual = manager.searchBy("Пушкин А.С.");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(expected));
    }

    @Test
        //Тест поиска книги по названию которой нет в списке
    void shouldFindNameNotExistBook() {
        manager.add(second);
        Product[] actual = manager.searchBy("Руслан и Людмила");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(expected));
    }

    @Test //Тест поиска телефон по модели
    public void shouldFindBySmartphoneManufacturer() {
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{sixth};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(expected));
    }

    @Test
        //Тест поиска смартфона по стране производителя которого нет в списке
    void shouldFindМanufacturerNotExistSmartphone() {
        manager.add(sixth);
        Product[] actual = manager.searchBy("Индия");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(expected));
    }

    @Test
        //Тест поиска смартфона по названию модели которой нет в списке
    void shouldFindNameNotExistSmartphone() {
        manager.add(sixth);
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(expected));
    }
}