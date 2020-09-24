package com.code.model;

public class ProductManager {
    private int id;
    private String code;
    private String name;
    private double price;
    private String producer;

    public ProductManager(int id, String code, String name, double price, String producer) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.producer = producer;
    }

    public ProductManager() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
