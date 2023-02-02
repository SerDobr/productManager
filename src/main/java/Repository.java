public class Repository {
    protected Product[] names = new Product[0];

    public void addProduct(Product name) {
        Product[] tmp = new Product[names.length + 1];
        for (int i = 0; i < names.length; i++) {
            tmp[i] = names[i];
        }
        tmp[tmp.length - 1] = name;
        names = tmp;
    }

    public Product[] findAll() {
        return names;
    }

    public void removeById(int id) {
        Product[] tmp = new Product[names.length - 1];
        int copyToIndex = 0;
        for (Product name : names) {
            if (name.getId() != id) {
                tmp[copyToIndex] = name;
                copyToIndex++;
            }
        }
        names = tmp;
    }
}
