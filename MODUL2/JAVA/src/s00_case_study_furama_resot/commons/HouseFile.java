package s00_case_study_furama_resot.commons;

import s00_case_study_furama_resot.models.House;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HouseFile {
    private static final String FILE_HOUSE_PATH = "E:\\TRANHUUHIEN-C0520G1\\MODUL2\\JAVA\\src\\s00_case_study_furama_resot\\data\\house.csv";

    public void writeHouse() throws IOException {
        List<House> houseList = House.getHouseList();
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(FILE_HOUSE_PATH);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (House house : houseList) {
                bufferedWriter.append(house.getId());
                bufferedWriter.append(",");
                bufferedWriter.append(house.getNameService());
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(house.getAreaUsed()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(house.getRentalCosts()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(house.getMaxPeople()));
                bufferedWriter.append(",");
                bufferedWriter.append(house.getTypeOfRent());
                bufferedWriter.append(",");
                bufferedWriter.append(house.getStandardRoom());
                bufferedWriter.append(",");
                bufferedWriter.append(house.getDescriptionOther());
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(house.getNumberFloors()));
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

    public void readerHouse() throws IOException {
        List<House> houseList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        File file = new File(FILE_HOUSE_PATH);
        if (file.exists()) {
            System.err.println("File not Found!!");
            System.exit(0);
        }
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            String[] arrayHouse;
            House myHouse = new House();
            while ((line = bufferedReader.readLine()) != null) {
                arrayHouse = line.split(",");
                myHouse.setId(arrayHouse[0]);
                myHouse.setNameService(arrayHouse[1]);
                myHouse.setAreaUsed(Double.parseDouble(arrayHouse[2]));
                myHouse.setRentalCosts(Double.parseDouble(arrayHouse[3]));
                myHouse.setMaxPeople(Integer.parseInt(arrayHouse[4]));
                myHouse.setTypeOfRent(arrayHouse[5]);
                myHouse.setStandardRoom(arrayHouse[6]);
                myHouse.setDescriptionOther(arrayHouse[7]);
                myHouse.setNumberFloors(Integer.parseInt(arrayHouse[8]));
                houseList.add(myHouse);
                House.setHouseList(houseList);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
            fileReader.close();
        }


    }
}
