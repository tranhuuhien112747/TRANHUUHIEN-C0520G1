package model;

public class CustomerUserService {
    private String customerId;
    private String customerName;
    private int contractId;
    private String serviceId;
    private String serviceName;
    private String attachServiceName;

    public CustomerUserService() {
    }

    public CustomerUserService(String customerId, String customerName, int contractId,
                               String serviceId, String serviceName, String attachServiceName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contractId = contractId;
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.attachServiceName = attachServiceName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }
}
