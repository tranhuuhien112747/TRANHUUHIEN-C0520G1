package com.code.repository;

import com.code.model.ProductManager;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer, ProductManager> productList;

    static {
        productList = new TreeMap<>();
        productList.put(1, new ProductManager(1, "SP-1", "IphoneX", 5000, "Apple"));
        productList.put(2, new ProductManager(2, "SP-2", "SamSung S9-Pro", 5000, "SamSung"));
        productList.put(3, new ProductManager(3, "SP-3", "Oppo Reno-3", 5000, "Oppo"));
        productList.put(4, new ProductManager(4, "SP-4", "Nokia A9", 5000, "Nokia"));
        productList.put(5, new ProductManager(5, "SP-5", "Xiaomi-real7", 5000, "Xiaomi"));
    }

    @Override
    public List<ProductManager> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(ProductManager product) {
        productList.put(product.getId(), product);
    }

    @Override
    public ProductManager findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, ProductManager product) {
        productList.put(id, product);

    }

    @Override
    public void remove(int id) {
        productList.remove(id);

    }
}
