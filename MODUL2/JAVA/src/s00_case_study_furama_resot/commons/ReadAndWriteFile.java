package s00_case_study_furama_resot.commons;

import s00_case_study_furama_resot.models.*;

import java.io.*;
import java.util.List;

public class ReadAndWriteFile {
    private static final String FILE_CUSTOMER_PATH = "E:\\TRANHUUHIEN-C0520G1\\MODUL2\\JAVA\\src\\s00_case_study_furama_resot\\data\\customer.csv";
    static final String FILE_VILLA_PATH = "E:\\TRANHUUHIEN-C0520G1\\MODUL2\\JAVA\\src\\s00_case_study_furama_resot\\data\\villa.csv";
    static final String FILE_HOUSE_PATH = "E:\\TRANHUUHIEN-C0520G1\\MODUL2\\JAVA\\src\\s00_case_study_furama_resot\\data\\house.csv";
    static final String FILE_ROOM_PATH = "E:\\TRANHUUHIEN-C0520G1\\MODUL2\\JAVA\\src\\s00_case_study_furama_resot\\data\\room.csv";
    static final String FILE_BOOKING_PATH = "E:\\TRANHUUHIEN-C0520G1\\MODUL2\\JAVA\\src\\s00_case_study_furama_resot\\data\\booking.csv";
    static List<Villa> villaList = Villa.getVillaList();
    static List<House> houseList = House.getHouseList();
    static List<Room> roomList = Room.getRoomList();
    static List<Customer> customerList = Customer.getCustomerList();

    public static String getFileBookingPath() {
        return FILE_BOOKING_PATH;
    }

    public static String getFileCustomerPath() {
        return FILE_CUSTOMER_PATH;
    }

    public static String getFileVillaPath() {
        return FILE_VILLA_PATH;
    }

    public static String getFileHousePath() {
        return FILE_HOUSE_PATH;
    }

    public static String getFileRoomPath() {
        return FILE_ROOM_PATH;
    }

    public static void readFile(String filePath) throws IOException {
        File file = new File(filePath);
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
                String id = arrayData[0];
                String nameService = arrayData[1];
                double areaUsed = Double.parseDouble(arrayData[2]);
                double rentalCosts = Double.parseDouble(arrayData[3]);
                int maxPeople = Integer.parseInt(arrayData[4]);
                String typeOfRent = arrayData[5];
                switch (filePath) {
                    case FILE_VILLA_PATH: {
                        String standardRoom = arrayData[6];
                        String descriptionOther = arrayData[7];
                        double areaPool = Double.parseDouble(arrayData[8]);
                        int numberFloors = Integer.parseInt(arrayData[9]);
                        Villa myVilla = new Villa(id, nameService, areaUsed, rentalCosts, maxPeople, typeOfRent, standardRoom, descriptionOther, areaPool, numberFloors);
                        villaList.add(myVilla);
                        Villa.setVillaList(villaList);
                        break;
                    }
                    case FILE_HOUSE_PATH: {
                        String standardRoom = arrayData[6];
                        String descriptionOther = arrayData[7];
                        int numberFloors = Integer.parseInt(arrayData[8]);
                        House myHouse = new House(id, nameService, areaUsed, rentalCosts, maxPeople, typeOfRent, standardRoom, descriptionOther, numberFloors);
                        houseList.add(myHouse);
                        House.setHouseList(houseList);
                        break;
                    }
                    case FILE_ROOM_PATH:
                        String freeServices = arrayData[6];
                        Room myRoom = new Room(id, nameService, areaUsed, rentalCosts, maxPeople, typeOfRent, freeServices);
                        roomList.add(myRoom);
                        Room.setRoomList(roomList);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
            fileReader.close();
        }

    }

    public static void writerFile(String filePath) throws IOException {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
            bufferedWriter = new BufferedWriter(fileWriter);
            if (filePath.equals(FILE_VILLA_PATH)) {
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
            } else if (filePath.equals(FILE_HOUSE_PATH)) {
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
            } else if (filePath.equals(FILE_ROOM_PATH)) {
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
            } else if (filePath.equals(FILE_CUSTOMER_PATH)) {
                for (Customer customer : customerList) {
                    bufferedWriter.append(customer.getIdCard());
                    bufferedWriter.append(",");
                    bufferedWriter.append(customer.getNameCustomer());
                    bufferedWriter.append(",");
                    bufferedWriter.append(customer.getDateOfBirth());
                    bufferedWriter.append(",");
                    bufferedWriter.append(customer.getGender());
                    bufferedWriter.append(",");
                    bufferedWriter.append(customer.getPhoneNumber());
                    bufferedWriter.append(",");
                    bufferedWriter.append(customer.getEmail());
                    bufferedWriter.append(",");
                    bufferedWriter.append(customer.getTypeCustomer());
                    bufferedWriter.append(",");
                    bufferedWriter.append(customer.getAddress());
                    bufferedWriter.append("\n");
                }
            }
            bufferedWriter.flush();
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
            fileWriter.close();
        }
    }

    public static void readFileCustomer(String filePath) throws IOException {
        File file = new File(filePath);
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
                String idCard = arrayData[0];
                String nameCustomer = arrayData[1];
                String dateOfBirth = arrayData[2];
                String gender = arrayData[3];
                String phoneNumber = arrayData[4];
                String email = arrayData[5];
                String typeCustomer = arrayData[6];
                String address = arrayData[7];
                Customer customer = new Customer(idCard, nameCustomer, dateOfBirth, gender, phoneNumber, email, typeCustomer, address);
                customerList.add(customer);
                Customer.setCustomerList(customerList);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static void writerBooking(String filePath) throws IOException {
        List<Customer> customerList = Customer.getCustomerList();
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(filePath, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer : customerList) {
                if (customer.getServices() != null) {
                    bufferedWriter.append(customer.getIdCard());
                    bufferedWriter.append(",");
                    bufferedWriter.append(customer.getNameCustomer());
                    bufferedWriter.append(",");
                    bufferedWriter.append(customer.getGender());
                    bufferedWriter.append(",");
                    bufferedWriter.append(customer.getDateOfBirth());
                    bufferedWriter.append(",");
                    bufferedWriter.append(customer.getTypeCustomer());
                    bufferedWriter.append(",");
                    bufferedWriter.append(customer.getAddress());
                    bufferedWriter.append(",");
                    if (customer.getServices() instanceof Villa) {
                        Villa villa = (Villa) customer.getServices();
                        bufferedWriter.append(villa.getId());
                        bufferedWriter.append(",");
                        bufferedWriter.append(villa.getNameService());
                    } else if (customer.getServices() instanceof House) {
                        House house = (House) customer.getServices();
                        bufferedWriter.append(house.getId());
                        bufferedWriter.append(",");
                        bufferedWriter.append(house.getNameService());
                    } else if (customer.getServices() instanceof Room) {
                        Room room = (Room) customer.getServices();
                        bufferedWriter.append(room.getId());
                        bufferedWriter.append(",");
                        bufferedWriter.append(room.getNameService());
                    }
                }
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
}
