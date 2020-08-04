package s00_case_study_furama_resot.models;

import s00_case_study_furama_resot.commons.RegexService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    @Override
    public void showInformation() {
        System.out.printf("%-15s%-20s%-20.3f%-20.3f%-10d%-15s%-20s%-25s%-10d", super.getId(), super.getNameService(),
                super.getAreaUsed(), super.getRentalCosts(), super.getMaxPeople(), super.getTypeOfRent(), standardRoom,
                descriptionOther, numberFloors);
    }


}
