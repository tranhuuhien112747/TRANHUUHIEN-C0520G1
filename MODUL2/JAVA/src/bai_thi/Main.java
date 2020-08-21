package bai_thi;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, NotFoundProductException {
        ReadAndWrite.readFile();
        ProductFunction productFunction = new ProductFunction();
        productFunction.displayMainMenu();
    }
}
