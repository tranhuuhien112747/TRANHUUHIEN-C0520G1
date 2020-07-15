package javacollection_tree_and_map.exercise.arraylist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        while (true) {
            System.out.println("Menu: ");
            System.out.println("1. Add New Product: ");
            System.out.println("2. Edit Information: ");
            System.out.println("3. Delete Product: ");
            System.out.println("4. Show Information: ");
            System.out.println("5. Search Product By Name: ");
            System.out.println("6. Sort Product By Price: ");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");
            int select = input.nextInt();
            switch (select) {
                case 1:
                    productManager.addNewProduct();
                    break;
                case 2:
                    System.out.println("Enter Id Product you want to edit: ");
                    int id = input.nextInt();
                    productManager.editProduct(id);
                    break;
                case 3:
                    break;
                case 4:
                    productManager.showListProduct();
                    break;
                case 5:

                    System.out.println("Enter the product name you want to search");
                    input.nextLine();
                    String name = input.nextLine();
                    productManager.searchProduct(name);
                    break;
                case 6:
                    productManager.sortProdutc();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("failed");

            }
        }
    }
}
