package dao.serviceDao;

import model.Employee;
import model.Service;

import java.util.List;

public interface ServiceDAO {
    List<Service> findAllService();

    void create(Service service);

    void update(Service service);

    void delete(String id);

    Service findById(String id);

    List<Service> searchName(String name);

    boolean checkServiceIdExists(String id);
}

