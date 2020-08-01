package s00_case_study_furama_resot.commons;

import s00_case_study_furama_resot.models.Room;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RoomFile {
    private static final String FILE_ROOM_PATH = "E:\\TRANHUUHIEN-C0520G1\\MODUL2\\JAVA\\src\\s00_case_study_furama_resot\\data\\room.csv";

    public void writeRoom() throws IOException {
        List<Room> roomList = Room.getRoomList();
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(FILE_ROOM_PATH);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Room room : roomList) {
                bufferedWriter.append(room.getId());
                bufferedWriter.append(",");
                bufferedWriter.append(room.getNameService());
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(room.getAreaUsed()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(room.getRentalCosts()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(room.getMaxPeople()));
                bufferedWriter.append(",");
                bufferedWriter.append(room.getTypeOfRent());
                bufferedWriter.append(",");
                bufferedWriter.append(room.getFreeServices());
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

    public void readRoom() throws IOException {
        List<Room> roomList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        File file = new File(FILE_ROOM_PATH);
        if (!file.exists()) {
            System.err.println("File Not Found!!!");
            System.exit(0);
        }
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            String[] arrayRoom;
            Room myRoom = new Room();
            while ((line = bufferedReader.readLine()) != null) {
                arrayRoom = line.split(",");
                myRoom.setId(arrayRoom[0]);
                myRoom.setNameService(arrayRoom[1]);
                myRoom.setAreaUsed(Double.parseDouble(arrayRoom[2]));
                myRoom.setRentalCosts(Double.parseDouble(arrayRoom[3]));
                myRoom.setMaxPeople(Integer.parseInt(arrayRoom[4]));
                myRoom.setTypeOfRent(arrayRoom[5]);
                myRoom.setFreeServices(arrayRoom[6]);
                roomList.add(myRoom);
                Room.setRoomList(roomList);
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
