package dao;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductDaoImplement implements ProductDAO {
    private static Map<String, Product> productMap = new TreeMap<>();

    static {
        productMap.put("1A", new Product("1A", "Smart Tv", 6000000, "Blue", "Panasonic"));
        productMap.put("2A", new Product("2A", "GL 7X-Zen", 7500000, "Black", "GL"));
        productMap.put("3A", new Product("3A", "Note-A9", 6000000, "Blue", "Samsung"));
        productMap.put("4A", new Product("4A", "Sony Pro8", 6000000, "White", "Sony"));
        productMap.put("5A", new Product("5A", "IP X", 6000000, "Blue", "Apple"));
        productMap.put("6A", new Product("6A", "Zeno 3 ", 6000000, "Gray", "Oppo"));
        productMap.put("7A", new Product("7A", "Xiaomi Note 10", 6000000, "Gold", "Xiaomi"));
        productMap.put("8A", new Product("8A", "Nokia 7.2", 6000000, "Blue", "Window"));
        productMap.put("9A", new Product("9A", "Realme 6-Pro", 6000000, "Black", "Realme"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void create(Product product) {
        productMap.put(product.getId(), product);

    }

    @Override
    public void update(String id, Product product) {
        productMap.put(id, product);

    }

    @Override
    public void delete(String id) {
        productMap.remove(id);
    }

    @Override
    public Product findById(String id) {
        return productMap.get(id);
    }
}
