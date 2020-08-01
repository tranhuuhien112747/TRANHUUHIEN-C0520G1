package s00_case_study_furama_resot.commons;

import s00_case_study_furama_resot.models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VillaFile {
    private static final String FILE_VILLA_PATH = "E:\\TRANHUUHIEN-C0520G1\\MODUL2\\JAVA\\src\\s00_case_study_furama_resot\\data\\villa.csv";

    public static void writeVilla() throws IOException {
        List<Villa> villaList = Villa.getVillaList();
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(FILE_VILLA_PATH);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Villa villa : villaList) {
                bufferedWriter.append(villa.getId());
                bufferedWriter.append(",");
                bufferedWriter.append(villa.getNameService());
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(villa.getAreaUsed()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(villa.getRentalCosts()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(villa.getMaxPeople()));
                bufferedWriter.append(",");
                bufferedWriter.append(villa.getTypeOfRent());
                bufferedWriter.append(",");
                bufferedWriter.append(villa.getStandardRoom());
                bufferedWriter.append(",");
                bufferedWriter.append(villa.getDescriptionOther());
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(villa.getAreaPool()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(villa.getNumberFloors()));
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

    public static void readVilla() throws IOException {
        List<Villa> villaList = new ArrayList<>();
        File file = new File(FILE_VILLA_PATH);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        if (!file.exists()) {
            System.err.println("File Not Found !!!");
            System.exit(0);
        }
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            String[] arrayVilla;
            while ((line = bufferedReader.readLine()) != null) {
                Villa myVilla = new Villa();
                arrayVilla = line.split(",");
                myVilla.setId(arrayVilla[0]);
                myVilla.setNameService(arrayVilla[1]);
                myVilla.setAreaUsed(Double.parseDouble(arrayVilla[2]));
                myVilla.setRentalCosts(Double.parseDouble(arrayVilla[3]));
                myVilla.setMaxPeople(Integer.parseInt(arrayVilla[4]));
                myVilla.setTypeOfRent(arrayVilla[5]);
                myVilla.setStandardRoom(arrayVilla[6]);
                myVilla.setDescriptionOther(arrayVilla[7]);
                myVilla.setAreaPool(Double.parseDouble(arrayVilla[8]));
                myVilla.setNumberFloors(Integer.parseInt(arrayVilla[9]));
                villaList.add(myVilla);
            }
            Villa.setVillaList(villaList);
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
