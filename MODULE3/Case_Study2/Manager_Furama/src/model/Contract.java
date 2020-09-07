package model;

import java.util.Date;

public class Contract {
    private int contractId;
    private Date contractStart;
    private Date contractEnd;
    private double contractDeposit;
    private double contractMoneyTotal;
    private int employeeId;
    private int customerId;
    private int serviceId;

    public Contract() {
    }

    public Contract(int contractId, Date contractStart, Date contractEnd, double contractDeposit,
                    double contractMoneyTotal, int employeeId, int customerId, int serviceId) {
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
}
