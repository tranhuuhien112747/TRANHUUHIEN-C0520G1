package s00_case_study_furama_resot.models;

import java.io.Serializable;

/**
 * Khu nghỉ dưỡng Furama sẽ cung cấp các dịch vụ cho thuê Villa, House, Room, tất cả các dịch vụ này sẽ bao gồm
 * các thông tin: Tên dịch vụ, diện tích sử dụng, chi phí thuê, Số lượng người tối đa, Kiểu thuê (bao gồm thuê theo năm,
 * tháng, ngày, giờ).Resort còn cung cấp các dịch vụ đi kèm.
 */
abstract class Services {
    private String id;
    private String nameService;
    private double areaUsed;
    private double rentalCosts;
    private int maxPeople;
    private String typeOfRent;
//    protected AccompaniedService accompaniedService;

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

//    public Services(String nameService, double areaUsed, double rentalCosts, int maxPeople, String typeOfRent, String id
//            , AccompaniedService accompaniedService) {
//        this.nameService = nameService;
//        this.areaUsed = areaUsed;
//        this.rentalCosts = rentalCosts;
//        this.maxPeople = maxPeople;
//        this.typeOfRent = typeOfRent;
//        this.id = id;
//        this.accompaniedService = accompaniedService;
//    }

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
