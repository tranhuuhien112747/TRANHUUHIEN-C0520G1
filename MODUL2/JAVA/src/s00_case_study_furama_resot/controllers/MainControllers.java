package s00_case_study_furama_resot.controllers;

import java.io.IOException;

public class MainControllers {
    public static void main(String[] args) throws IOException {
        MainFunction mainController = new MainFunction();
        mainController.readAllFile();
        mainController.displayMainMenu();
    }
}
