package bai_thi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductFunction {
    public void displayMainMenu() throws IOException, NotFoundProductException {
        Scanner input = new Scanner(System.in);
        int choose;
        while (true) {
            System.out.println(" ___________________**  MENU  **___________________ ");
            System.out.println("|                                                  |");
            System.out.println("|             1. Add New Product.                  |");
            System.out.println("|             2. Remove Product.                   |");
            System.out.println("|             3. Show Information of Product.      |");
            System.out.println("|             4. Search Product                    |");
            System.out.println("|             5. Exit.                             |");
            System.out.println("|__________________________________________________|");
            System.out.print("Enter your choice: ");
            choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    showProduct();
                    System.out.println("Enter code you want to remove:");
                    String code = input.nextLine();
                    removeProduct(code);
                    showProduct();
                    break;
                case 3:
                    showProduct();
                    System.out.println("Enter code you want to edit:");
                    String code1 = input.nextLine();
                    eDitProduct(code1);
                    showProduct();
                    break;
                case 4:
                    searchProduct();
                    break;
                case 5:
                    ReadAndWrite.writerFile();
                    System.exit(0);
                default:
                    System.err.println();
            }
        }
    }

    public void addNewProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("__________Add New Product_________");
        System.out.println("                                    ");
        System.out.println("         1. Add New ProductImport.   ");
        System.out.println("         2. Add New ProductExport.    ");
        System.out.println("Enter choose");
        int choose = Integer.parseInt(input.nextLine());
        switch (choose) {
            case 1:
                ProductImport productImport = new ProductImport();
                productImport.addNewProductImport();
                break;
            case 2:
                ProductExport productExport = new ProductExport();
                productExport.addNewProductExport();
                break;
            default:
                System.out.println();
        }
    }

    public void showProduct() {
        Collections.sort(Product.getProductList(), new SortProduct());
        System.out.println();
        System.out.println("__________----Show Product-----_________");
        System.out.println();
        for (Product product : Product.getProductList()) {
            if (product instanceof ProductImport) {
                ProductImport productImport = (ProductImport) product;
                productImport.showProductIx();
            } else if (product instanceof ProductExport) {
                ProductExport export = (ProductExport) product;
                export.showProductEx();
            }
            System.out.println();
        }
    }

    public void removeProduct(String code) throws IOException, NotFoundProductException {
        Scanner input = new Scanner(System.in);
        boolean check = false;
        Product temp = null;
        for (Product product : Product.getProductList()) {
            if (code.equals(product.getCodeProduct())) {
                check = true;
                temp = product;
                break;
            }
        }
        if (check) {
            System.out.println("You want to remove (yes/no) " + "[ " + temp.getNameProduct() + "] in list ?");
            char anwser = input.nextLine().charAt(0);
            if (anwser == 'y') {
                Product.getProductList().remove(temp);
                System.out.println("Remove Success!!");
            } else {
                displayMainMenu();
            }
        } else {
            System.err.println("Can not find the product need remove");

        }
        ReadAndWrite.writerFile();
    }

    public static void searchProduct() throws NotFoundProductException {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("__________Search Product_________");
        System.out.println("                                    ");
        System.out.println("         1. Search By Name Product   ");
        System.out.println("         2. Search By Name Product    ");
        System.out.println("Enter your choose");
        int select = Integer.parseInt(input.nextLine());
        switch (select) {
            case 1:
                System.out.println("Enter Product name you want to search:");
                String name = input.nextLine();
                searchNameProduct(name);
                break;
            case 2:
                System.out.println("Enter Product code you want to search:");
                String code = input.nextLine();
                searchCodeProduct(code);
                break;
            default:
                System.out.println();
        }
    }

    public static void searchNameProduct(String name) throws NotFoundProductException {
        List<Product> productList = new ArrayList<>();
        for (Product product : Product.getProductList()) {
            if (product.getNameProduct().contains(name)) {
                productList.add(product);
            }
        }
        if (!productList.isEmpty()) {
            System.out.println();
            System.out.println("-------PRODUCT LIST HAVE" + " [ " + name + " ]-----------");
            System.out.println();
            for (Product product : productList) {
                if (product instanceof ProductExport) {
                    ((ProductExport) product).showProductEx();
                } else if (product instanceof ProductImport) {
                    ((ProductImport) product).showProductIx();
                }
                System.out.println();
            }
        } else {
            try {
                throw new NotFoundProductException();
            } catch (NotFoundProductException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void searchCodeProduct(String code) throws NotFoundProductException {
        List<Product> productList = new ArrayList<>();
        for (Product product : Product.getProductList()) {
            if (product.getCodeProduct().contains(code)) {
                productList.add(product);
            }
        }
        if (!productList.isEmpty()) {
            System.out.println();
            System.out.println("-------PRODUCT LIST HAVE" + " [ " + code + " ]-----------");
            System.out.println();
            for (Product product : productList) {
                if (product instanceof ProductExport) {
                    ((ProductExport) product).showProductEx();
                } else if (product instanceof ProductImport) {
                    ((ProductImport) product).showProductIx();
                }
                System.out.println();
            }
        } else {
            try {
                throw new NotFoundProductException();
            } catch (NotFoundProductException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    static void eDitProduct(String code) throws IOException {
        Scanner input = new Scanner(System.in);
        boolean check = false;
        for (Product product : Product.getProductList()) {
            if (code.equals(product.getCodeProduct())) {
                System.out.println("Enter ID");
                product.setId(Integer.parseInt(input.nextLine()));
                System.out.println("Enter Code Product:");
                product.setCodeProduct(input.nextLine());
                System.out.println("Enter Product's name:");
                product.setNameProduct(input.nextLine());
                System.out.println("Enter price :");
                product.setPriceProduct(Integer.parseInt(input.nextLine()));
                System.out.println("Enter amount:");
                product.setAmount(Integer.parseInt(input.nextLine()));
                System.out.println("Enter producer");
                product.setProducer(input.nextLine());
                if (product instanceof ProductImport) {
                    System.out.println("Enter price Import");
                    ((ProductImport) product).setPriceImport(Integer.parseInt(input.nextLine()));
                    System.out.println("Enter province");
                    ((ProductImport) product).setProvince(input.nextLine());
                    System.out.println("Enter tax");
                    ((ProductImport) product).setTax(Integer.parseInt(input.nextLine()));
                    System.out.println("SUCCESS!!");
                } else if (product instanceof ProductExport) {
                    System.out.println("Enter price Export");
                    ((ProductExport) product).setPriceExport(Integer.parseInt(input.nextLine()));
                    System.out.println("Enter Nation");
                    ((ProductExport) product).setNation(input.nextLine());
                    System.out.println("SUCCESS!!");
                }
                check = true;
                break;
            }
        }
        if (!check) {
            System.err.println("Can not find the product code");
        }
        ReadAndWrite.writerFile();
    }
}
