package bai_thi;

import java.util.ArrayList;
import java.util.List;

public abstract class Product {
    private int id = 0;
    private String codeProduct;
    private String nameProduct;
    private int priceProduct;
    private int amount;
    private String producer;
    static List<Product> productList = new ArrayList<>();

    public Product() {
    }

    public static List<Product> getProductList() {
        return productList;
    }

    public static void setProductList(List<Product> productList) {
        Product.productList = productList;
    }

    public Product(int id, String codeProduct, String nameProduct, int priceProduct, int amount, String producer) {
        this.id = id;
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.amount = amount;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    abstract void showInforProduct();
}
