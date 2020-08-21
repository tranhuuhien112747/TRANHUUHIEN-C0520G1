package bai_thi;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ProductImport extends Product {
    private int priceImport;
    private String province;
    private int tax;
    static List<Product> productList = Product.getProductList();

    public ProductImport() {
    }

    public ProductImport(int id, String codeProduct, String nameProduct, int priceProduct, int amount, String producer,
                         int priceImport, String province, int tax) {
        super(id, codeProduct, nameProduct, priceProduct, amount, producer);
        this.priceImport = priceImport;
        this.province = province;
        this.tax = tax;
    }

    public int getPriceImport() {
        return priceImport;
    }

    public void setPriceImport(int priceImport) {
        this.priceImport = priceImport;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }


    public void showProductIx() {
        System.out.printf("%-5d%-15s%-20s%-15d%-5d%-20s%-15d%-20s%-15d", this.getId(), this.getCodeProduct(),
                this.getNameProduct(), this.getPriceProduct(), this.getAmount(), this.getProducer(), this.priceImport, this.province, this.tax);
        System.out.println();
    }

    @Override
    void showInforProduct() {
        showProductIx();
    }

    public void addNewProductImport() {
        ProductImport productImport;
        int id, priceProduct, tax, amount, priceImport;
        String codeProduct, nameProduct, producer, province;
        Scanner input = new Scanner(System.in);
        if (productList.size() != 0) {
            id = productList.get(productList.size() - 1).getId() + 1;
        } else {
            id = 1;
        }
        System.out.println("Enter Code Product:");
        codeProduct = input.nextLine();
        System.out.println("Enter Product's name:");
        nameProduct = input.nextLine();
        System.out.println("Enter price :");
        priceProduct = Integer.parseInt(input.nextLine());
        System.out.println("Enter amount:");
        amount = Integer.parseInt(input.nextLine());
        System.out.println("Enter producer");
        producer = input.nextLine();
        System.out.println("Enter price Import");
        priceImport = Integer.parseInt(input.nextLine());
        System.out.println("Enter province");
        province = input.nextLine();
        System.out.println("Enter tax");
        tax = Integer.parseInt(input.nextLine());
        System.out.println("SUCCESS!!");
        productImport = new ProductImport(id, codeProduct, nameProduct, priceProduct, amount, producer, priceImport, province, tax);
        productList.add(productImport);
        productImport.showProductIx();
    }

}
