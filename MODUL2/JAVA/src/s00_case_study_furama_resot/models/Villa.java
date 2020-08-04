package s00_case_study_furama_resot.models;

import java.util.*;


import s00_case_study_furama_resot.commons.RegexService;

/**
 * Villa will have more information: Standard room, Description other , Pool area, Number of floors.
 */
public class Villa extends Services {
    private String standardRoom;
    private String descriptionOther;
    private double areaPool;
    private int numberFloors;
    private static List<Villa> villaList = new ArrayList<>();

    public static List<Villa> getVillaList() {
        return villaList;
    }

    public static void setVillaList(List<Villa> villaList) {
        Villa.villaList = villaList;
    }

    public Villa() {
    }

    public Villa(String id, String nameService, double areaUsed, double rentalCosts, int maxPeople, String typeOfRent,
                 String standardRoom, String descriptionOther, double areaPool, int numberFloors) {
        super(id, nameService, areaUsed, rentalCosts, maxPeople, typeOfRent);
        this.standardRoom = standardRoom;
        this.descriptionOther = descriptionOther;
        this.areaPool = areaPool;
        this.numberFloors = numberFloors;
    }


//    public Villa(String id, String nameService, double areaUsed, double rentalCosts, int maxPeople, String typeOfRent,
//                 String standardRoom, String descriptionOther, double areaPool, int numberFloors, AccompaniedService accompaniedService) {
//        super(nameService, areaUsed, rentalCosts, maxPeople, typeOfRent, id, accompaniedService);
//        this.standardRoom = standardRoom;
//        this.descriptionOther = descriptionOther;
//        this.areaPool = areaPool;
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

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    public static void showVilla() {
        System.out.printf("%-5s%-15s%-20s%-20s%-20s%-15s%-15s%-20s%-25s%-20s%-15s", "NO", "ID", "SERVICES",
                "AREA USED", "RENTAL COSTS", "PEOPLE", "TYPE RENT", "STANDARD ROOM",
                "DESCRIPTION", "AREA POOL", "FLOORS");
        System.out.println("\n");
        int count = 0;
        for (Villa villa : villaList) {
            System.out.printf("%-5s%-15s%-20s%-20s%-20s%-15s%-15s%-20s%-25s%-20s%-15s", ++count, villa.getId(),
                    villa.getNameService(), villa.getAreaUsed(), villa.getRentalCosts(), villa.getMaxPeople(), villa.getTypeOfRent(),
                    villa.getStandardRoom(), villa.getDescriptionOther(), villa.getAreaPool(), villa.getNumberFloors());
            System.out.println("\n");
        }
    }

    @Override
    public void showInformation() {
       showVilla();
    }

    public void addNewVilla() {
        Villa villa;
        String id, typeOfRent, nameService, standardRoom, descriptionOther;
        double areaUsed, rentalCosts, areaPool;
        int maxPeople, numberFloors;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Id: ");
        id = RegexService.checkIdVila(input.nextLine());
        System.out.print("Enter Services name's :");
        nameService = RegexService.checkFormat(input.nextLine());
        System.out.print("Enter Area:");
        areaUsed = RegexService.checkArea((input.nextLine()));
        System.out.print("Enter rental Costs:");
        rentalCosts = RegexService.checkRentalCost(input.nextLine());
        System.out.print("Enter the maximum number of people:");
        maxPeople = RegexService.checkMaxPeople((input.nextLine()));
        System.out.print("Enter rental type(including rent by year, month, day, time):");
        typeOfRent = RegexService.checkFormat(input.nextLine());
        System.out.print("Enter room standard (Vip, Business, Normal):");
        standardRoom = RegexService.checkRoomStandard(input.nextLine().toLowerCase());
        System.out.println("Enter another comfort description:");
        descriptionOther = RegexService.checkDescription(input.nextLine());
        System.out.print("Enter pool area:");
        areaPool = RegexService.checkArea((input.nextLine()));
        System.out.print("Enter number of floor:");
        numberFloors = RegexService.checkFloor(input.nextLine());
        System.out.println("ENTER THE INFORMATION SUCCESSFULLY !!!!");
        villa = new Villa(id, nameService, areaUsed, rentalCosts, maxPeople, typeOfRent, standardRoom, descriptionOther, areaPool, numberFloors);
        villaList.add(villa);
        villa.showInformation();

    }

    public static void showAllNameVillaNotDuplicate() {
        Set<String> setVilla = new TreeSet<>();
        for (Services element : Villa.villaList) {
            setVilla.add(element.getNameService());
        }
        System.out.println("----------------List Name Villa---------------");
        int count = 0;
        System.out.printf("%-5s%-20s", "NO", "Name Villa");
        System.out.println("\n");
        for (String element : setVilla) {
            System.out.printf("%-5s%-20s", ++count, element);
            System.out.println("\n");
        }
    }


}
