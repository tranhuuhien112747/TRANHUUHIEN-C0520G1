package bai_thi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductExport extends Product {
    private int priceExport;
    private String nation;
    static List<ProductExport> productExportList = new ArrayList<>();
    static List<Product> productList = Product.getProductList();

    public ProductExport() {
    }

    public int getPriceExport() {
        return priceExport;
    }

    public void setPriceExport(int priceExport) {
        this.priceExport = priceExport;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public static List<ProductExport> getProductExportList() {
        return productExportList;
    }

    public static void setProductExportList(List<ProductExport> productExportList) {
        ProductExport.productExportList = productExportList;
    }

    public ProductExport(int id, String codeProduct, String nameProduct, int priceProduct, int amount, String producer,
                         int priceExport, String nation) {
        super(id, codeProduct, nameProduct, priceProduct, amount, producer);
        this.priceExport = priceExport;
        this.nation = nation;
    }

    public void showProductEx() {
        System.out.printf("%-5d%-15s%-20s%-15d%-5d%-20s%-15d%-20s", this.getId(), this.getCodeProduct(),
                this.getNameProduct(), this.getPriceProduct(), this.getAmount(), this.getProducer(), this.priceExport, this.nation);
        System.out.println();
    }

    @Override
    void showInforProduct() {
    }

    public void addNewProductExport() {
        ProductExport productExport;
        int id, priceProduct, amount, priceExport;
        String codeProduct, nation, nameProduct, producer;
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
        System.out.println("Enter price Export");
        priceExport = Integer.parseInt(input.nextLine());
        System.out.println("Enter Nation");
        nation = input.next();
        System.out.println("SUCCESS!!");
        productExport = new ProductExport(id, codeProduct, nameProduct, priceProduct, amount, producer, priceExport, nation);
        productList.add(productExport);
        productExport.showProductEx();
    }

}
