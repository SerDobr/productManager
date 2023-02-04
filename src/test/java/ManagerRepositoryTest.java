import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerRepositoryTest {
    Repository repo = new Repository();
    ManagerRepository manager = new ManagerRepository(repo);
    Product name1 = new Smartphone(1, "Smartphone 1", 100, "manufacturer1");
    Product name2 = new Book(2, "Book", 200, "author2");
    Product name3 = new Smartphone(3, "Smartphone 3", 300, "manufacturer3");
    Product name4 = new Book(4, "Book2", 400, "author4");

        Product name5 = new Smartphone(5, "Smartphone 1", 500, "manufacturer5");
//    Product name6 = new Book(6, "Book 6", 600, "author6");
//    Product name7 = new Smartphone(7, "Smartphone 7", 700, "manufacturer7");
//    Product name8 = new Book(8, "Book 8", 800, "author8");
//    Product name9 = new Smartphone(9, "Smartphone 9", 900, "manufacturer9");
//    Product name10 = new Book(10, "Book", 1000, "author10");
    @BeforeEach
    public void setup() {
        manager.add(name1);
        manager.add(name2);
        manager.add(name3);
        manager.add(name4);
//manager.add(name5);
//manager.add(name6);
//manager.add(name7);
//manager.add(name8);
//manager.add(name9);
//manager.add(name10);
    }

    @Test
    public void shouldAdd() {
        Product[] expected = {name1, name2, name3, name4};
        Product[] actual = manager.findAllProduct();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphone() {
        Product[] expected = {name1, name3};
        Product[] actual = manager.searchBy("Smartphone");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveId() {
        repo.removeById(2);
        Product[] expected = {name1, name3, name4};
        Product[] actual = manager.findAllProduct();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveNotId() {
        Assertions.assertThrows(NotFoundException.class,()->{
            repo.removeById(20);
        });
    }
    @Test
    public void shouldAddProductExistingId() {
        Assertions.assertThrows(AlreadyExistsException.class,()->{
            repo.addProduct(name4);
        });
    }
    @Test
    public void shouldSearchByBook() {
        Product[] expected = {name2, name4};
        Product[] actual = manager.searchBy("Book");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByID() {
        Product[] expected = {name4};
        Product[] actual = new Product[]{repo.findById(4)};
        Assertions.assertArrayEquals(expected, actual);
    }
}

