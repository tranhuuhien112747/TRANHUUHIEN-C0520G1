package bo.serviceBo;

import model.Service;

import java.util.List;

public interface ServiceBO {
    List<Service> findAllService();

    void create(Service service);

    void update(Service service);

    void delete(int id);

    Service findById(int id);

    List<Service> searchName(String name);
}
