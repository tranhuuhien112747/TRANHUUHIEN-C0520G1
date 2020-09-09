package model;

import java.sql.Date;

public class Contract {
    private int contractId;
    private String contractStart;
    private String contractEnd;
    private double contractDeposit;
    private double contractMoneyTotal;
    private int employeeId;
    private String customerId;
    private String serviceId;

    public Contract() {
    }

    public Contract(int contractId, String contractStart, String contractEnd, double contractDeposit,
                    double contractMoneyTotal, int employeeId, String customerId, String serviceId) {
        this.contractId = contractId;
        this.contractStart = contractStart;
        this.contractEnd = contractEnd;
        this.contractDeposit = contractDeposit;
        this.contractMoneyTotal = contractMoneyTotal;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContractStart() {
        return contractStart;
    }

    public void setContractStart(String contractStart) {
        this.contractStart = contractStart;
    }

    public String getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(String contractEnd) {
        this.contractEnd = contractEnd;
    }

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractMoneyTotal() {
        return contractMoneyTotal;
    }

    public void setContractMoneyTotal(double contractMoneyTotal) {
        this.contractMoneyTotal = contractMoneyTotal;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String  getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String  customerId) {
        this.customerId = customerId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String  serviceId) {
        this.serviceId = serviceId;
    }
}
