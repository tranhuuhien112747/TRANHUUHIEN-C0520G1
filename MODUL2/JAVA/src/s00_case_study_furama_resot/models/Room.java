package s00_case_study_furama_resot.models;

import s00_case_study_furama_resot.commons.RegexService;

import java.util.*;

/**
 * The room has more information: Free service included.
 */
public class Room extends Services {
    private String freeServices;
    private AccompaniedService accompaniedService;
    private static List<Room> roomList = new ArrayList<>();


    public Room() {
    }

    public Room(String id, String nameService, double areaUsed, double rentalCosts, int maxPeople, String typeOfRent, String freeServices) {
        super(id, nameService, areaUsed, rentalCosts, maxPeople, typeOfRent);
        this.freeServices = freeServices;
    }

//    public Room(String nameService, double areaUsed, double rentalCosts, int maxPeople, String typeOfRent, String id,
//                String freeServices, AccompaniedService accompaniedService) {
//        super(nameService, areaUsed, rentalCosts, maxPeople, typeOfRent, id, accompaniedService);
//        this.freeServices = freeServices;
//        this.accompaniedService = accompaniedService;
//    }

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
        double areaUsed, rentalCosts;
        int maxPeople;
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
        System.out.println("ENTER THE INFORMATION SUCCESSFULLY !!!!");
        room = new Room(id, nameService, areaUsed, rentalCosts, maxPeople, typeOfRent, freeServices);
        roomList.add(room);
        room.showInformation();
    }

    public static void showRoom() {
        System.out.printf("%-5s%-15s%-20s%-20s%-20s%-15s%-15s%-20s", "NO", "ID", "SERVICES",
                "AREA USED", "RENTAL COSTS", "PEOPLE", "TYPE RENT", "SERVICES FREE");
        System.out.println("\n");
        int count = 0;
        for (Room room : roomList) {
            System.out.printf("%-5s%-15s%-20s%-20.3f%-20.3f%-10d%-15s%-30s", ++count, room.getId(),
                    room.getNameService(), room.getAreaUsed(), room.getRentalCosts(), room.getMaxPeople(), room.getTypeOfRent(),
                    room.freeServices);
            System.out.println("\n");
        }
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
}
