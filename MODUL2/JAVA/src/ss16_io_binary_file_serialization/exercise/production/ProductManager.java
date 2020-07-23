package ss16_io_binary_file_serialization.exercise.production;

import javacollection_tree_and_map.exercise.arraylist.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    public static final String FILE_PATH = "src/ss16_io_binary_file_serialization/exercise/production/dataProduct.txt";
    List<Production> listProduct = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public void addNewProduct() throws IOException {
        String codeProduct;
        double priceProduct;
        String nameProduct;
        String manufacturer;
        String description;
       boolean check;
        do {
            check = false;
            System.out.println("Enter Code Product : ");
            codeProduct = input.nextLine();
            for (int i = 0; i < listProduct.size(); i++) {
                if (codeProduct.equals(listProduct.get(i).getCodeProduct())) {
                    System.err.println("ID already in the list. Please enter");
                    check = true;
                    break;
                }
            }
        } while (check);
        System.out.println("Enter Product name:");
        nameProduct = input.nextLine();
        System.out.println("Enter Manufacturer:");
        manufacturer = input.nextLine();

        do {
            check = false;
            System.out.println("Enter Product price: ");
            priceProduct = input.nextDouble();
            if (priceProduct < 0) {
                System.err.println("Product price is invalid.Please enter");
                check = true;
            }
        } while (check);
        input.nextLine();
        System.out.println("Enter Other Descriptions:");
        description = input.nextLine();
        Production product = new Production(codeProduct, nameProduct, manufacturer, priceProduct, description);
        listProduct.add(product);
        writerBynary();
    }
    public void writerBynary() throws IOException{
        FileOutputStream fos = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fos = new FileOutputStream(FILE_PATH);
            objectOutputStream = new ObjectOutputStream(fos);

            objectOutputStream.writeObject(listProduct);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            objectOutputStream.close();
        }
    }
    public void showListProduct() throws IOException {
        if (listProduct.isEmpty()) {
            System.out.println("The list is empty");
        } else {
           readerBynary();
        }
    }

    public void readerBynary() throws IOException {
        FileInputStream fis = null;
        ObjectInputStream objectInputStream = null;
        try {
            fis = new FileInputStream(FILE_PATH);
            objectInputStream = new ObjectInputStream(fis);
            List<Production> listProduct = (List<Production>) objectInputStream.readObject();
            for (Production production : listProduct) {
                System.out.println(production.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            objectInputStream.close();
        }
    }

    public Production searchProduct(String name) {
        Production data = null;
        boolean check = false;
        for (Production product : listProduct) {
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

    public void editProduct(String code) throws IOException {
        boolean check = false;
        for (Production product : listProduct) {
            System.out.println(product.toString());
            if (code.equals(product.getCodeProduct())) {
                System.out.println("Enter Product name:");
                product.setNameProduct(input.nextLine());
                System.out.println("Enter Manufacturer:");
                product.setManufacturer(input.nextLine());
                System.out.println("Enter Product price: ");
                product.setPriceProduct(input.nextDouble());
                input.nextLine();
                System.out.println("Enter Other Descriptions:");
                product.setDescription(input.nextLine());
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("failed");
        }
        writerBynary();
    }
    public void deleteProduct(String code) throws IOException {
        Production temp = null;
        boolean check = false;
        if(listProduct.isEmpty()){
            System.out.println("List is empty!!!");
        }else {
            for (Production product : listProduct) {
                if (code.equals(product.getCodeProduct())) {
                    temp = product;
                    check = true;
                    break;
                }
            }

            if (check) {
                listProduct.remove(temp);
                System.out.println("Delete successful :  " + temp);

            } else {
                System.out.println("No exist !!!");
            }
        }
        writerBynary();
    }
}
