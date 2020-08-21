package ss01_case_study_james.commons;

import ss01_case_study_james.controllers.MainFunction;
import ss01_case_study_james.models.KeyWord;

import java.io.*;
import java.util.Map;

public class ReadAndWriteWord {
    static final String FILE_PATH = "E:\\TRANHUUHIEN-C0520G1\\MODUL2\\JAVA\\src\\ss01_case_study_james\\data\\dictionary.txt";
    static Map<String, KeyWord> dictionary = MainFunction.getWordsMap();

    public static Map<String, KeyWord> getDictionary() {
        return dictionary;
    }

    public static void writerFileWord() throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.err.println("File Not Found");
        }
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(dictionary);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            objectOutputStream.close();
        }
    }

    public static void readerFileWord() throws IOException {
        File file = new File(FILE_PATH);
        if ((!file.exists())) {
            System.err.println("File Not Found !!!");
        }
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            dictionary = (Map<String, KeyWord>) objectInputStream.readObject();
            MainFunction.setWordsMap(dictionary);
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
}
