package bai_thi_1.controller;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ReadAndWriterContacts.readFile();
        Function function = new Function();
        function.displayMainMenu();
    }

}