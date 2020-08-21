package bai_thi;

import java.io.*;
import java.util.List;

public class ReadAndWrite {
    static final String FILE_PATH_EXPORT = "E:\\TRANHUUHIEN-C0520G1\\MODUL2\\JAVA\\src\\bai_thi\\product.csv";
    static List<Product> productList = Product.getProductList();

    public static void readFile() throws IOException {
        File file = new File(FILE_PATH_EXPORT);
        if (!file.exists()) {
            System.err.println("File Not Found !!");
        }
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            String[] arrayData;
            while ((line = bufferedReader.readLine()) != null) {
                arrayData = line.split(",");
                int id = Integer.parseInt(arrayData[0]);
                String code = arrayData[1];
                String name = arrayData[2];
                int price = Integer.parseInt(arrayData[3]);
                int amount = Integer.parseInt(arrayData[4]);
                String producer = arrayData[5];
                if (arrayData.length == 9) {
                    int priceImport = Integer.parseInt(arrayData[6]);
                    String province = arrayData[7];
                    int tax = Integer.parseInt(arrayData[8]);
                    ProductImport productImport = new ProductImport(id, code, name, price, amount, producer, priceImport, province, tax);
                    productList.add(productImport);
                    Product.setProductList(productList);
                } else {
                    int priceExport = Integer.parseInt(arrayData[6]);
                    String nation = arrayData[7];
                    ProductExport productExport = new ProductExport(id, code, name, price, amount, producer, priceExport, nation);
                    productList.add(productExport);
                    Product.setProductList(productList);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
    }

    public static void writerFile() throws IOException {
        File file = new File(FILE_PATH_EXPORT);
        if (!file.exists()) {
            System.err.println("File Not Found !!");
        }
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Product product : productList) {
                bufferedWriter.append(String.valueOf(product.getId()));
                bufferedWriter.append(",");
                bufferedWriter.append(product.getCodeProduct());
                bufferedWriter.append(",");
                bufferedWriter.append(product.getNameProduct());
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(product.getPriceProduct()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(product.getAmount()));
                bufferedWriter.append(",");
                bufferedWriter.append(product.getProducer());
                bufferedWriter.append(",");
                if (product instanceof ProductImport) {
                    ProductImport productImport = (ProductImport) product;
                    bufferedWriter.append(String.valueOf(productImport.getPriceImport()));
                    bufferedWriter.append(",");
                    bufferedWriter.append(productImport.getProvince());
                    bufferedWriter.append(",");
                    bufferedWriter.append(String.valueOf(productImport.getTax()));
                } else if (product instanceof ProductExport) {
                    ProductExport export = (ProductExport) product;
                    bufferedWriter.append(String.valueOf(export.getPriceExport()));
                    bufferedWriter.append(",");
                    bufferedWriter.append(export.getNation());
                }
                bufferedWriter.append("\n");
            }
            bufferedWriter.flush();
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
            fileWriter.close();
        }
    }
}
