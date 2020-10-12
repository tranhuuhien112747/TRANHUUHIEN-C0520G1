package com.codegym.casestudyfurama.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Service {
    @Id
    private String serviceId;

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
}
