package bo.serviceBo;

import model.Service;

import java.util.List;

public interface ServiceBO {
    List<Service> findAllService();

    void create(Service service);

    void update(Service service);

    void delete(String id);

    Service findById(String id);

    List<Service> searchName(String name);

    public List<String> checkValidateCreateService(String id, String area, String  cost, String maxPeople, String  pool, String  numberFloor);

    public List<String> checkValidateEditService(String area, String  cost, String maxPeople, String  pool, String  numberFloor);
}
