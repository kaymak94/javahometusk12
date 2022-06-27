
import ru.netology.repository.ProductRepository;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Book(1, "Crime and Punishment", 345, "Dostoevsky");
        Product product2 = new Smartphone(2, "Galaxy", 24567, "Samsung");
        Product product3 = new Book(3, "For whom the Bell Tolls", 567, "Hemingway");
        Product product4 = new Smartphone(4, "Iphone", 45897, "Apple");
        Product product5 = new Smartphone(4, "IphoneX", 120000, "Apple");

        ProductRepository repo = new ProductRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);

        repo.removeById(2);

        Product[] all = repo.findAll();
    }

}
