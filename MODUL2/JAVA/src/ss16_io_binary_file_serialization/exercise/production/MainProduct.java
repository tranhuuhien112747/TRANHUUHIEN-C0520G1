package ss16_io_binary_file_serialization.exercise.production;

import java.io.IOException;
import java.util.Scanner;

public class MainProduct {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        while (true) {
            System.out.println("Menu: ");
            System.out.println("1. Add New Product: ");
            System.out.println("2. Show Information: ");
            System.out.println("3. Search Product By Name: ");
            System.out.println("4. Edit Product Information: ");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            int select = input.nextInt();
            switch (select) {
                case 1:
                    productManager.addNewProduct();
                    break;
                case 2:
                    productManager.showListProduct();
                    break;
                case 3:
                    System.out.println("Enter the product name you want to search");
                    input.nextLine();
                    String name = input.nextLine();
                    productManager.searchProduct(name);
                    break;
                case 4:
                    System.out.println("Enter the product code you want to edit");
                    input.nextLine();
                    String code = input.nextLine();
                    productManager.editProduct(code);
                    break;
                case 5:
                    System.out.println("Enter the product code you want to delete");
                    input.nextLine();
                    String codeDel = input.nextLine();
                    productManager.deleteProduct(codeDel);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("failed");

            }
        }
    }
}
