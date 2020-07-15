package javacollection_tree_and_map.exercise.arraylist;

public class Product {
    private String nameProduct;
    private int iD;
    private double priceProduct;

    public Product() {
    }

    public Product(String nameProduct, int iD, double priceProduct) {
        this.nameProduct = nameProduct;
        this.iD = iD;
        this.priceProduct = priceProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {

        this.nameProduct = nameProduct;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    @Override
    public String toString() {
        return "ID = " + iD + ", Name = ' " + nameProduct + " ' " + ", Price = ' " + priceProduct + " '";
    }
}
