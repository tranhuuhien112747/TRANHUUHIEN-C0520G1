package ss16_io_binary_file_serialization.exercise.production;

import java.io.Serializable;

public class Production implements Serializable {
    private String codeProduct;
    private String nameProduct;
    private String manufacturer;
    private double priceProduct;
    private String description;

    public Production() {
    }

    public Production(String codeProduct, String nameProduct, String manufacturer, double priceProduct, String description) {
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.manufacturer = manufacturer;
        this.priceProduct = priceProduct;
        this.description = description;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Code = " + codeProduct + ", Name = " + nameProduct + " , Manufacturer =  " + manufacturer + ", Price = "
                + priceProduct + " , Description = " + description;
    }
}
