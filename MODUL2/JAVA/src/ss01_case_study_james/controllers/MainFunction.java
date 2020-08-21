package ss01_case_study_james.controllers;

import s00_case_study_furama_resot.commons.RegexService;
import ss01_case_study_james.commons.ReadAndWriteWord;
import ss01_case_study_james.models.*;

import java.io.IOException;
import java.util.*;

public class MainFunction {
    private static Map<String, KeyWord> wordsMap = new TreeMap<>();
    static List<Noun> nounList = new ArrayList<>();
    static List<Adjective> adjectiveList = new ArrayList<>();
    static List<Verb> verbList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static Map<String, KeyWord> getWordsMap() {
        return wordsMap;
    }

    public static void setWordsMap(Map<String, KeyWord> wordsMap) {
        MainFunction.wordsMap = wordsMap;
    }

    public void addNewWords() {
        KeyWord myWord = new KeyWord();
        Entities myEntities = new Entities();
        boolean check = false;
        System.out.println("Enter new words:");
        myWord.setKeyWord(input.nextLine().toLowerCase());
        System.out.println("Enter pronounce :");
        myEntities.setPronounce(input.nextLine());
        while (!check) {
            System.out.println("1. Noun         ");
            System.out.println("2. Adjective    ");
            System.out.println("3. Verb         ");
            System.out.println("4. Finish       ");
            System.out.println("Choose the type of definition :");
            int choose = RegexService.checkChooseMenu(input.nextLine());
            switch (choose) {
                case 1:
                    addNoun();
                    break;
                case 2:
                    addAdjective();
                    break;
                case 3:
                    addVerb();
                    break;
                case 4:
                    myEntities.setAdjectiveList(adjectiveList);
                    myEntities.setNounList(nounList);
                    myEntities.setVerbList(verbList);
                    check = true;
                    break;
                default:
                    System.out.println("Value not in menu. Please Enter !!!");
            }
        }
        System.out.println("Enter synonymous :");
        myEntities.setSynonymous(input.nextLine());
        myWord.setEntities(myEntities);
        wordsMap.put(myWord.getKeyWord(), myWord);
        myWord.showDictionary();
    }

    public void addVerb() {
        Verb myVerb = new Verb();
        System.out.println("Verb");
        System.out.println("________");
        System.out.println("Enter define: ");
        myVerb.setDefine(input.nextLine());
        System.out.println("Enter sentence:");
        myVerb.setSentence(input.nextLine());
        System.out.println("Enter sentence meaning:");
        myVerb.setSentenceMeaning(input.nextLine());
        verbList.add(myVerb);
    }

    public void addNoun() {
        Noun myNoun = new Noun();
        System.out.println("-Noun");
        System.out.println("_________");
        System.out.println("Enter define:  ");
        myNoun.setDefine(input.nextLine());
        System.out.println("Enter sentence:");
        myNoun.setSentence(input.nextLine());
        System.out.println("Enter sentence meaning:");
        myNoun.setSentenceMeaning(input.nextLine());
        nounList.add(myNoun);
    }

    public void addAdjective() {
        Adjective myAdjective = new Adjective();
        System.out.println("-Adjective");
        System.out.println("_______");
        System.out.println("Enter define:");
        myAdjective.setDefine(input.nextLine());
        System.out.println("Enter sentence:");
        myAdjective.setSentence(input.nextLine());
        System.out.println("Enter sentence meaning:");
        myAdjective.setSentenceMeaning(input.nextLine());
        adjectiveList.add(myAdjective);
    }

    public void dropWords() throws IOException {
        boolean check = false;
        System.out.println("Enter words you want to delete: ");
        String remove = input.nextLine().toLowerCase();
        for (String keyWord : wordsMap.keySet()) {
            if (keyWord.equals(remove)) {
                check = true;
                break;
            }
        }
        if (check) {
            wordsMap.remove(remove);
        } else {
            System.out.println("Not Found!!!");
        }
        ReadAndWriteWord.writerFileWord();
    }

    public void lookupWords() {
        Scanner input = new Scanner(System.in);
        boolean check = false;
        System.out.println("Enter word you want to search: ");
        String searchWord = input.nextLine().toLowerCase();
        for (String keyWord : wordsMap.keySet()) {
            if (keyWord.equals(searchWord)) {
                check = true;
                break;
            }
        }
        if (check) {
            wordsMap.get(searchWord).showDictionary();
        } else {
            System.out.println("Not Found!!!");

        }
    }

    public void showKeyWord() {
        System.out.println("______DICTIONARY______");
        int count = 0;
        System.out.printf("%-5s%-20s", " ", "   ");
        System.out.println();
        for (String key : wordsMap.keySet()) {
            System.out.printf("%-5s%-20s", ++count + ")", key);
        }
        System.out.println();
        System.out.println("_______________________");
        System.out.println();
    }

}
