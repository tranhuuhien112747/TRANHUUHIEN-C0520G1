package javacollection_tree_and_map.exercise.arraylist;

import java.util.*;

public class ProductManager {
    List<Product> myList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public void addNewProduct() {
        int iD;
        double priceProduct;
        String nameProduct;
        boolean check;
        do {
            check = false;
            System.out.println("ENTER ID:");
            iD = input.nextInt();
            for (int i = 0; i < myList.size(); i++) {
                if (myList.get(i).getiD() == iD) {
                    System.out.println("ID already in the list. Please enter");
                    check = true;
                    break;
                }
            }
        } while (iD < 0 || check);
        //-----thêm tên-------------
        input.nextLine();
        System.out.println("ENTER  PRODUCT'S NAME::");
        nameProduct = input.nextLine();
        //---------------them giá sản phẩm
        do {
            check = false;
            System.out.println("ENTER THE PRODUCT PRICE  ");
            priceProduct = input.nextInt();
            if (priceProduct < 0) {
                System.out.println("Product price is invalid.Please enter");
                check = true;
            }
        } while (check);
        //---------add vao myList------------
        myList.add(new Product(nameProduct, iD, priceProduct));
        System.out.println("Successful");
    }

    public void showListProduct() {
        if (myList.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            int count = 0;
            for (Product product : myList) {
                System.out.println("STT = " + ++count + ", " + product.toString());
            }
            System.out.println();
        }
    }

    public void editProduct(int iD) {
        boolean check = false;
        for (Product product : myList) {
            System.out.println(product);
            if (product.getiD() == iD) {
                System.out.println("Enter new Product name: ");
                input.nextLine();
                product.setNameProduct(input.nextLine());
                System.out.println("Enter new Product price: ");
                product.setPriceProduct(input.nextDouble());
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("failed");
        }
    }

    public Product searchProduct(String name) {
        Product data = null;
        boolean check = false;
        for (Product product : myList) {
            if (name.equals(product.getNameProduct())) {
                data = product;
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println(data);
        } else {
            System.out.println("Not Found");
        }
        return data;
    }

    public void sortProdutc() {
        System.out.println("1. AscendingSort");
        System.out.println("2. DecreaseSort");
        System.out.println("Enter your choice: ");
        int select = input.nextInt();
        switch (select) {
            case 1:
                Collections.sort(myList, new SortAscendingByPrice());
                break;
            case 2:
                Collections.sort(myList, new SortDescendingByPrice());
                break;
        }
    }
}
