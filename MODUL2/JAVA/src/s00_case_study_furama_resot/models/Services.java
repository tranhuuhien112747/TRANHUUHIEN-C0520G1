package s00_case_study_furama_resot.models;

import java.io.Serializable;

/**
 * Furama Resort will provide Villa, House, and Room rental services, all of which will include the following information:
 * Service name, area of use, rental cost, Maximum number of people, Type of rent (including year, month, day, hour) .
 * Resort also provides accompanying services.
 */
abstract class Services {
    private String id;
    private String nameService;
    private double areaUsed;
    private double rentalCosts;
    private int maxPeople;
    private String typeOfRent;

    public Services() {
    }

    public Services(String id, String nameService, double areaUsed, double rentalCosts, int maxPeople, String typeOfRent) {
        this.nameService = nameService;
        this.areaUsed = areaUsed;
        this.rentalCosts = rentalCosts;
        this.maxPeople = maxPeople;
        this.typeOfRent = typeOfRent;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(double areaUsed) {
        this.areaUsed = areaUsed;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(String typeOfRent) {
        this.typeOfRent = typeOfRent;
    }

    public void setId(String id) {
        this.id = id;
    }

    abstract void showInformation();
}
