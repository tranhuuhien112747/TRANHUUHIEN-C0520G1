package model;

public class Service {
    private int serviceId;
    private String serviceName;
    private double area;
    private double serviceCost;
    private int maxPeople;
    private int rentTypeId;
    private int serviceTypeId;
    private String standardRoom;
    private String description;
    private double areaPool;
    private int numberFloor;

    public Service() {
    }

    public Service(int serviceId, String serviceName, double area, double serviceCost, int maxPeople, int rentTypeId,
                   int serviceTypeId, String standardRoom, String description, double areaPool, int numberFloor) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.area = area;
        this.serviceCost = serviceCost;
        this.maxPeople = maxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.description = description;
        this.areaPool = areaPool;
        this.numberFloor = numberFloor;
    }

    public Service(int serviceId, String serviceName, double area, double serviceCost, int maxPeople, int rentTypeId, int serviceTypeId) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.area = area;
        this.serviceCost = serviceCost;
        this.maxPeople = maxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
    }

    public Service(int serviceId, String serviceName, double area, double serviceCost, int maxPeople, int rentTypeId,
                   int serviceTypeId, String standardRoom, String description, int numberFloor) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.area = area;
        this.serviceCost = serviceCost;
        this.maxPeople = maxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.description = description;
        this.numberFloor = numberFloor;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }
}
