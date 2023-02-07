import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerRepositoryTest {
    Repository repo = new Repository();
    ManagerRepository manager = new ManagerRepository(repo);
    Product name1 = new Smartphone(1, "Sony", 300, "Япония");
    Product name2 = new Book(2, "Записки юного врача", 200, "Булкагов");
    Product name3 = new Smartphone(3, "Samsung", 3000, "Япония");
    Product name4 = new Book(4, "Мастер и Маргарита", 400, "Булгаков");

    Product name5 = new Smartphone(5, "Nokia", 5000, "Финляндия");

    Product name6 = new Book(6, "Зеленая миля", 600, "Стивен Кинг");
    Product name7 = new Smartphone(7, "Sony", 7000, "Япония");
    Product name8 = new Book(8, "Братья Карамазовы", 800, "Достоевский");
    Product name9 = new Smartphone(9, "Siemens", 5000, "Германия");
    Product name10 = new Book(10, "Война и мир", 600, "Лев Толстой");

    @BeforeEach
    public void setup() {
        manager.add(name1);
        manager.add(name2);
        manager.add(name3);
        manager.add(name4);
        manager.add(name5);
        manager.add(name6);
        manager.add(name7);
        manager.add(name8);
        manager.add(name9);
        manager.add(name10);
    }

    @Test
    public void shouldAdd() {
        Product[] expected = {name1, name2, name3, name4, name5, name6, name7, name8, name9, name10};
        Product[] actual = manager.findAllProduct();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveId() {
        repo.removeById(2);
        Product[] expected = {name1, name3, name4, name5, name6, name7, name8, name9, name10};
        Product[] actual = manager.findAllProduct();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySamsung() {
        Product[] expected = {name3};
        Product[] actual = manager.searchBy("Samsung");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySony() {
        Product[] expected = {name1, name7};
        Product[] actual = manager.searchBy("Sony");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByGreenMile() {
        Product[] expected = {name6};
        Product[] actual = manager.searchBy("Зеленая миля");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNothingFits() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Honor");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldRemoveNotId() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(20);
        });
    }

    @Test
    public void shouldAddProductExistingId() {
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.addProduct(name4);
        });
    }


    @Test
    public void shouldSearchByID() {
        Product[] expected = {name4};
        Product[] actual = new Product[]{repo.findById(4)};
        Assertions.assertArrayEquals(expected, actual);
    }

}

