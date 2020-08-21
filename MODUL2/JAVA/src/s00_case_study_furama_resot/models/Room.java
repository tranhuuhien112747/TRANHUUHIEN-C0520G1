package s00_case_study_furama_resot.models;

import s00_case_study_furama_resot.commons.ReadAndWriteFile;
import s00_case_study_furama_resot.commons.RegexService;

import java.io.IOException;
import java.util.*;

/**
 * The room has more information: Free service included.
 */
public class Room extends Services {
    private String freeServices;
    private AccompaniedService accompaniedService;
    private static List<Room> roomList = new ArrayList<>();

    public AccompaniedService getAccompaniedService() {
        return accompaniedService;
    }

    public void setAccompaniedService(AccompaniedService accompaniedService) {
        this.accompaniedService = accompaniedService;
    }

    public Room() {
    }

    public Room(String id, String nameService, double areaUsed, double rentalCosts, int maxPeople, String typeOfRent, String freeServices) {
        super(id, nameService, areaUsed, rentalCosts, maxPeople, typeOfRent);
        this.freeServices = freeServices;
    }

    public Room(String id, String nameService, double areaUsed, double rentalCosts, int maxPeople, String typeOfRent, String freeServices, AccompaniedService accompaniedService) {
        super(id, nameService, areaUsed, rentalCosts, maxPeople, typeOfRent);
        this.freeServices = freeServices;
        this.accompaniedService = accompaniedService;
    }

    public static List<Room> getRoomList() {
        return roomList;
    }

    public static void setRoomList(List<Room> roomList) {
        Room.roomList = roomList;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    public void addNewRoom() {
        Scanner input = new Scanner(System.in);
        Room room;
        String id, typeOfRent, nameService, freeServices;
        double areaUsed, rentalCosts, price = 0.0;
        int maxPeople;
        String nameAccompaniedService = "NOT", unit = "NOT";
        System.out.print("Enter Id: ");
        id = RegexService.checkIdRoom(input.nextLine());
        System.out.print("Enter Services name's : ");
        nameService = RegexService.checkFormat(input.nextLine());
        System.out.print("Enter Area: ");
        areaUsed = RegexService.checkArea((input.nextLine()));
        System.out.print("Enter rental Costs: ");
        rentalCosts = RegexService.checkRentalCost(input.nextLine());
        System.out.print("Enter the maximum number of people: ");
        maxPeople = RegexService.checkMaxPeople(input.nextLine());
        System.out.print("Enter rental type(including rent by year, month, day, time): ");
        typeOfRent = RegexService.checkFormat(input.nextLine());
        System.out.print("Enter the free service included: ");
        freeServices = RegexService.checkDescription(input.nextLine());
        System.out.println("ban co muon them dich vu di kem (y/n");
        char ansew = input.nextLine().toLowerCase().charAt(0);
        if (ansew == 'y') {
            System.out.println("nhap ten dich vụ");
            nameAccompaniedService = input.nextLine();
            System.out.println("nhap dơn vị thuê");
            unit = input.nextLine();
            System.out.println("nhap gia thue");
            price = Double.parseDouble(input.nextLine());
        }
        AccompaniedService accompaniedService = new AccompaniedService(nameAccompaniedService, unit, price);
        System.out.println("ENTER THE INFORMATION SUCCESSFULLY !!!!");
        room = new Room(id, nameService, areaUsed, rentalCosts, maxPeople, typeOfRent, freeServices, accompaniedService);
        roomList.add(room);
        room.showInformation();
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeServices='" + freeServices + '\'' +
                ", accompaniedService=" + accompaniedService +
                "} " + super.toString();
    }

    public static void showRoom() {
        System.out.println("");
        System.out.println();
        System.out.printf("%-5s%-15s%-25s%-20s%-20s%-15s%-15s%-20s%-40s", "NO", "ID", "NAME SERVICES",
                "AREA USED", "RENTAL COSTS", "PEOPLE", "TYPE RENT", "SERVICES FREE", "AccompaniedService");
        System.out.println("\n");
        int count = 0;
        for (Room room : roomList) {
            System.out.printf("%-5s%-15s%-25s%-20.3f%-20.3f%-15d%-15s%-20s%-40s", ++count, room.getId(),
                    room.getNameService(), room.getAreaUsed(), room.getRentalCosts(), room.getMaxPeople(), room.getTypeOfRent(),
                    room.freeServices, room.accompaniedService);
            System.out.println("");
        }
        System.out.println("");
    }

    @Override
    public void showInformation() {
        showRoom();
    }

    public static void showAllNameRoomNotDuplicate() {
        Set<String> setRoom = new TreeSet<>();
        for (Services element : Room.roomList) {
            setRoom.add(element.getNameService());
        }
        System.out.println("------------List Name Room---------------");
        int count = 0;
        System.out.printf("%-5s%-20s", "NO", "Name Room");
        System.out.println("\n");
        for (String element : setRoom) {
            System.out.printf("%-5s%-20s", ++count, element);
            System.out.println("\n");
        }
    }

    public static void searchRoom(String name) {
        List<Room> myRoom = new ArrayList<>();
        int count = 0;
        for (Room room : roomList) {
            //if (room.getNameService().contains(name)){
            if (name.equals(room.getNameService())) {
                myRoom.add(room);
                count++;
            }
        }
        if (!myRoom.isEmpty()) {
            System.out.println("tim dc " + count + " ket qua :" + name);
            System.out.printf("%-5s%-15s%-25s%-20s%-20s%-15s%-15s%-20s%-40s", "NO", "ID", "NAME SERVICES",
                    "AREA USED", "RENTAL COSTS", "PEOPLE", "TYPE RENT", "SERVICES FREE", "AccompaniedService");
            System.out.println("\n");
            int order = 0;
            for (Room room : myRoom) {
                System.out.printf("%-5s%-15s%-25s%-20.3f%-20.3f%-15d%-15s%-20s%-35s", ++order, room.getId(),
                        room.getNameService(), room.getAreaUsed(), room.getRentalCosts(), room.getMaxPeople(), room.getTypeOfRent(),
                        room.freeServices, room.accompaniedService);
                System.out.println("");
            }
        } else {
            System.out.println("co " + count + " ket qua :" + name + " trong list room");
        }
    }

    public static void eDitRoom(String code) throws IOException {
        Scanner input = new Scanner(System.in);
        boolean check = false;
        System.out.printf("%-5s%-15s%-25s%-20s%-20s%-15s%-15s%-20s%-35s", "NO", "ID", "NAME SERVICES",
                "AREA USED", "RENTAL COSTS", "PEOPLE", "TYPE RENT", "SERVICES FREE", "AccompaniedService");
        System.out.println("\n");
        for (Room room : roomList) {
            if (code.equals(room.getId())) {
                System.out.printf("%-15s%-25s%-20.3f%-20.3f%-15d%-15s%-20s%-35s", room.getId(),
                        room.getNameService(), room.getAreaUsed(), room.getRentalCosts(), room.getMaxPeople(), room.getTypeOfRent(),
                        room.freeServices, room.accompaniedService.toString());
                System.out.print("Enter Id: ");
                room.setId(RegexService.checkIdRoom(input.nextLine()));
                System.out.print("Enter Services name's : ");
                room.setNameService(RegexService.checkFormat(input.nextLine()));
                System.out.print("Enter Area: ");
                room.setAreaUsed(RegexService.checkArea(input.nextLine()));
                System.out.print("Enter rental Costs: ");
                room.setRentalCosts(RegexService.checkRentalCost(input.nextLine()));
                System.out.print("Enter the maximum number of people: ");
                room.setMaxPeople(RegexService.checkMaxPeople(input.nextLine()));
                System.out.print("Enter rental type(including rent by year, month, day, time): ");
                room.setTypeOfRent(RegexService.checkFormat(input.nextLine()));
                System.out.print("Enter the free service included: ");
                room.setFreeServices(RegexService.checkDescription(input.nextLine()));
                System.out.println("nhap ten dich vu di kem");
                room.accompaniedService.setNameAccompaniedService(input.nextLine());
                System.out.println("ENTER THE INFORMATION SUCCESSFULLY !!!!");
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("k tìm thấy ");
        }
        ReadAndWriteFile.writerFile(ReadAndWriteFile.getFileRoomPath());
    }

}
