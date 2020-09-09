package bo.serviceBo;

import bo.checkValidate.Regex;
import dao.serviceDao.ServiceDAO;
import dao.serviceDao.ServiceDAOImpl;
import model.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceBOImpl implements ServiceBO {
    ServiceDAO serviceDAO = new ServiceDAOImpl();
    public static final String REGEX_ID_SERVICE = "^(DV-\\d{4})$";

    @Override
    public List<Service> findAllService() {
        return serviceDAO.findAllService();
    }

    @Override
    public void create(Service service) {
        serviceDAO.create(service);
    }

    @Override
    public void update(Service service) {

    }

    @Override
    public void delete(String id) {
        serviceDAO.delete(id);
    }

    @Override
    public Service findById(String id) {
        return serviceDAO.findById(id);
    }

    @Override
    public List<Service> searchName(String name) {
        return serviceDAO.searchName(name);
    }

    @Override
    public List<String> checkValidateCreateService(String id, String area, String cost, String maxPeople, String pool, String numberFloor) {
        List<String> messageList = new ArrayList<>(6);
        boolean checkValidateId = checkValidateServiceId(id);
        boolean checkValidateArea = Regex.checkRegexDoublePositive(area);
        boolean checkValidateCost = Regex.checkRegexDoublePositive(cost);
        boolean checkValidateMaxPerson = Regex.checkRegexIntegerPositive(maxPeople);
        boolean checkValidatePoolArea = Regex.checkRegexDoublePositive(pool);
        boolean checkValidateFloor = Regex.checkRegexIntegerPositive(numberFloor);
        if (!(checkValidateId && checkValidateArea && checkValidateCost && checkValidateMaxPerson && checkValidatePoolArea && checkValidateFloor)) {
            if (!checkValidateId) {
                messageList.add("ID format DV-XXXX (X from 0-9) and unlike");
            } else {
                messageList.add("");
            }
            if (!checkValidateArea) {
                messageList.add("Area must be positive number");
            } else {
                messageList.add("");
            }
            if (!checkValidateCost) {
                messageList.add("Cost must be positive number");
            } else {
                messageList.add("");
            }
            if (!checkValidateMaxPerson) {
                messageList.add("Person must be positive number");
            } else {
                messageList.add("");
            }
            if (!checkValidatePoolArea) {
                messageList.add("Pool Area must be positive number");
            } else {
                messageList.add("");
            }
            if (!checkValidateFloor) {
                messageList.add("Floor must be positive number");
            } else {
                messageList.add("");
            }
        }
        return messageList;
    }

    @Override
    public List<String> checkValidateEditService(String area, String cost, String maxPeople, String pool, String numberFloor) {
        List<String> messageList = new ArrayList<>();
        boolean checkValidateArea = Regex.checkRegexDoublePositive(area);
        boolean checkValidateCost = Regex.checkRegexDoublePositive(cost);
        boolean checkValidateMaxPerson = Regex.checkRegexIntegerPositive(maxPeople);
        boolean checkValidatePoolArea = Regex.checkRegexDoublePositive(pool);
        boolean checkValidateFloor = Regex.checkRegexIntegerPositive(numberFloor);
        if (!(checkValidateArea && checkValidateCost && checkValidateMaxPerson && checkValidatePoolArea && checkValidateFloor)) {
            if (!checkValidateArea) {
                messageList.add("Area must be positive number");
            } else {
                messageList.add("");
            }
            if (!checkValidateCost) {
                messageList.add("Cost must be positive number");
            } else {
                messageList.add("");
            }
            if (!checkValidateMaxPerson) {
                messageList.add("Person must be positive number");
            } else {
                messageList.add("");
            }
            if (!checkValidatePoolArea) {
                messageList.add("Pool Area must be positive number");
            } else {
                messageList.add("");
            }
            if (!checkValidateFloor) {
                messageList.add("Floor must be positive number");
            } else {
                messageList.add("");
            }
        }
        return messageList;
    }

    private boolean checkValidateServiceId(String id) {
        return !serviceDAO.checkServiceIdExists(id) && Regex.checkRegex(REGEX_ID_SERVICE, id);
    }
}

