//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//public class RepositoryTest {
//    Product name1 = new Smartphone(1, "Smartphone1", 100, "manufacturer1");
//    Product name2 = new Book(2, "Book2", 200, "author2");
//    Product name3 = new Smartphone(3, "Smartphone3", 300, "manufacturer3");
//    Product name4 = new Book(4, "Book4", 400, "author4");
//    Product name5 = new Smartphone(5, "Smartphone1", 500, "manufacturer5");
//    Product name6 = new Book(6, "Book6", 600, "author6");
//    Product name7 = new Smartphone(7, "Smartphone3", 700, "manufacturer7");
//    Product name8 = new Book(8, "Book8", 800, "author8");
//    Product name9 = new Smartphone(9, "Smartphone9", 900, "manufacturer9");
//    Product name10 = new Book(10, "Book10", 1000, "author10");
//
//    @Test
//    public void testAdd() {
//        Repository manager = new Repository();
//        manager.addProduct(name1);
//        manager.addProduct(name2);
//        manager.addProduct(name3);
//        manager.addProduct(name4);
//        manager.addProduct(name5);
//        manager.addProduct(name6);
//        manager.addProduct(name7);
//        manager.addProduct(name8);
//        manager.addProduct(name9);
//        manager.addProduct(name10);
//        Product[] expected = {name1, name2, name3, name4, name5, name6, name7, name8, name9, name10};
//        Product[] actual = manager.findAll();
//        Assertions.assertArrayEquals(expected, actual);
//
//    }
//
//    @Test
//    public void testRemoveById() {
//        Repository manager = new Repository();
//        manager.addProduct(name1);
//        manager.addProduct(name2);
//        manager.addProduct(name3);
//        manager.addProduct(name4);
//        manager.addProduct(name5);
//        manager.addProduct(name6);
//        manager.addProduct(name7);
//        manager.addProduct(name8);
//        manager.addProduct(name9);
//        manager.addProduct(name10);
//        manager.removeById(6);
//        Product[] expected = {name1, name2, name3, name4, name5, name7, name8, name9, name10};
//        Product[] actual = manager.findAll();
//        Assertions.assertArrayEquals(expected, actual);
//
//    }
//}