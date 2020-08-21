package bai_thi_1.controller;

import java.io.*;
import java.util.List;

public class ReadAndWriterContacts {
    static final String FILE_PATH_CONTACTS = "E:\\TRANHUUHIEN-C0520G1\\MODUL2\\JAVA\\src\\bai_thi_1\\data\\contacts.csv";
    static List<ManagerContacts> contactsList = ManagerContacts.getManagerContactsList();

    public static void writerFile() throws IOException {
        File file = new File(FILE_PATH_CONTACTS);
        if (!file.exists()) {
            System.err.println("File Not Found !!");
        }
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (ManagerContacts contacts : contactsList) {
                bufferedWriter.append(contacts.getName());
                bufferedWriter.append(",");
                bufferedWriter.append(contacts.getGender());
                bufferedWriter.append(",");
                bufferedWriter.append(contacts.getPhoneNumber());
                bufferedWriter.append(",");
                bufferedWriter.append(contacts.getGroup());
                bufferedWriter.append(",");
                bufferedWriter.append(contacts.getAddress());
                bufferedWriter.append(",");
                bufferedWriter.append(contacts.getEmail());
                bufferedWriter.append("\n");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
            fileWriter.close();
        }
    }

    public static void readFile() throws IOException {
        File file = new File(FILE_PATH_CONTACTS);
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
                String name = arrayData[0];
                String gender = arrayData[1];
                String phone = arrayData[2];
                String group = arrayData[3];
                String address = arrayData[4];
                String email = arrayData[5];
                ManagerContacts contacts = new ManagerContacts(name, gender, phone, group, address, email);
                contactsList.add(contacts);
                ManagerContacts.setManagerContactsList(contactsList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
    }
}


