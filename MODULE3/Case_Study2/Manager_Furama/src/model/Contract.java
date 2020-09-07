package model;

import java.sql.Date;

public class Contract {
    private int contractId;
    private Date contractStart;
    private Date contractEnd;
    private double contractDeposit;
    private double contractMoneyTotal;
    private int employeeId;
    private String customerId;
    private String serviceId;

    public Contract() {
    }

    public Contract(int contractId, Date contractStart, Date contractEnd, double contractDeposit,
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

    public Date getContractStart() {
        return contractStart;
    }

    public void setContractStart(Date contractStart) {
        this.contractStart = contractStart;
    }

    public Date getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(Date contractEnd) {
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
