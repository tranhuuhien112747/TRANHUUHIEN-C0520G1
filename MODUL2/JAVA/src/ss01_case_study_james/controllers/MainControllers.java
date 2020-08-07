package ss01_case_study_james.controllers;


import s00_case_study_furama_resot.commons.RegexService;
import ss01_case_study_james.commons.ReadAndWriteWord;

import java.io.IOException;
import java.util.Scanner;

public class MainControllers {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        MainFunction mainFunction = new MainFunction();
        ReadAndWriteWord.readerFileWord();
        while (true) {
            System.out.println("1. Add New Words");
            System.out.println("2. Lookup ");
            System.out.println("3. Drop ");
            System.out.println("4. Show Dictionary ");
            System.out.println("5. Exit");
            System.out.println("Enter your choose: ");
            int select = RegexService.checkChooseMenu(input.nextLine());
            switch (select) {
                case 1:
                    mainFunction.addNewWords();
                    break;
                case 2:
                    mainFunction.lookupWords();
                    break;
                case 3:
                    mainFunction.dropWords();
                    break;
                case 4:
                    mainFunction.showKeyWord();
                    break;
                case 5:
                    ReadAndWriteWord.writerFileWord();
                    System.exit(0);
                default:
                    System.err.println("Value not in menu. Please Enter !!!");
            }
        }
    }
}
