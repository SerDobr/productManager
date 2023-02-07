import static java.util.regex.Pattern.matches;

public class ManagerRepository {
    private Repository repo;


    public ManagerRepository(Repository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.addProduct(product);
    }

    public Product[] findAllProduct() {
        Product[] all = repo.findAll();
        return all;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll())
            if (matches(product, text)) {
                int res = result.length + 1;
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;

        } else {
            return false;
        }
    }
}

