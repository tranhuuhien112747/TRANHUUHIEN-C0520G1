package s00_case_study_furama_resot.models;

import s00_case_study_furama_resot.commons.RegexService;

import java.util.*;

/**
 * House will have more information: Standard room, Description other, Number of floors.
 */
public class House extends Services {
    private String standardRoom;
    private String descriptionOther;
    private int numberFloors;
    private static List<House> houseList = new ArrayList<>();

    public static List<House> getHouseList() {
        return houseList;
    }

    public static void setHouseList(List<House> houseList) {
        House.houseList = houseList;
    }

    public House() {
    }

    public House(String id, String nameService, double areaUsed, double rentalCosts, int maxPeople, String typeOfRent,
                 String standardRoom, String descriptionOther, int numberFloors) {
        super(id, nameService, areaUsed, rentalCosts, maxPeople, typeOfRent);
        this.standardRoom = standardRoom;
        this.descriptionOther = descriptionOther;
        this.numberFloors = numberFloors;
    }

//    public House(String id, String nameService, double areaUsed, double rentalCosts, int maxPeople, String typeOfRent,
//                 String standardRoom, String descriptionOther, int numberFloors, AccompaniedService accompaniedService) {
//        super(nameService, areaUsed, rentalCosts, maxPeople, typeOfRent, id, accompaniedService);
//        this.standardRoom = standardRoom;
//        this.descriptionOther = descriptionOther;
//        this.numberFloors = numberFloors;
//    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOther() {
        return descriptionOther;
    }

    public void setDescriptionOther(String descriptionOther) {
        this.descriptionOther = descriptionOther;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    public void addNewHouse() {
        Scanner input = new Scanner(System.in);
        House house;
        String id, typeOfRent, nameService, standardRoom, descriptionOther;
        double areaUsed, rentalCosts;
        int maxPeople, numberFloors;
        System.out.print("Enter Id: ");
        id = RegexService.checkIdHouse(input.nextLine());
        System.out.print("Enter Services name's :");
        nameService = RegexService.checkFormat(input.nextLine());
        System.out.print("Enter Area:");
        areaUsed = RegexService.checkArea(input.nextLine());
        System.out.print("Enter rental Costs: ");
        rentalCosts = RegexService.checkRentalCost(input.nextLine());
        System.out.print("Enter the maximum number of people:");
        maxPeople = RegexService.checkMaxPeople(input.nextLine());
        System.out.print("Enter rental type(including rent by year, month, day, time):");
        typeOfRent = RegexService.checkFormat(input.nextLine());
        System.out.print("Enter room standard (Vip, Business, Normal): ");
        standardRoom = RegexService.checkRoomStandard(input.nextLine().toLowerCase());
        System.out.println("Enter another comfort description: ");
        descriptionOther = RegexService.checkDescription(input.nextLine());
        System.out.print("Enter number of floor:");
        numberFloors = RegexService.checkFloor(input.nextLine());
        System.out.println("ENTER THE INFORMATION SUCCESSFULLY !!!!");
        house = new House(id, nameService, areaUsed, rentalCosts, maxPeople, typeOfRent, standardRoom, descriptionOther, numberFloors);
        houseList.add(house);
        house.showInformation();
    }

    public static void showHouse() {
        System.out.printf("%-5s%-15s%-25s%-20s%-20s%-15s%-15s%-20s%-25s%-20s%-15s", "NO", "ID", "NAME SERVICES",
                "AREA USED", "RENTAL COSTS", "PEOPLE", "TYPE RENT", "STANDARD ROOM",
                "DESCRIPTION", "AREA POOL", "FLOORS");
        System.out.println("\n");
        int count = 0;
        for (House house : houseList) {
            System.out.printf("%-5s%-15s%-25s%-20s%-20s%-15s%-15s%-20s%-25s%-15s", ++count, house.getId(),
                    house.getNameService(), house.getAreaUsed(), house.getRentalCosts(), house.getMaxPeople(), house.getTypeOfRent(),
                    house.getStandardRoom(), house.getDescriptionOther(), house.getNumberFloors());
            System.out.println("\n");
        }
    }

    @Override
    public void showInformation() {
        showHouse();
    }

    public static void showAllNameHouseNotDuplicate() {
        Set<String> setHouse = new TreeSet<>();
        for (Services element : House.houseList) {
            setHouse.add(element.getNameService());
        }
        System.out.println("----------------List Name House---------------");
        int count = 0;
        System.out.printf("%-5s%-20s", "NO", "Name House");
        System.out.println("\n");
        for (String element : setHouse) {
            System.out.printf("%-5s%-20s", ++count, element);
            System.out.println("\n");
        }
    }


}
