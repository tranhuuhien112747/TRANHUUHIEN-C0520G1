package bo.serviceBo;

import dao.serviceDao.ServiceDAO;
import dao.serviceDao.ServiceDAOImpl;
import model.Service;

import java.util.List;

public class ServiceBOImpl implements ServiceBO{
    ServiceDAO serviceDAO = new  ServiceDAOImpl();
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
    public void delete(int id) {

    }

    @Override
    public Service findById(int id) {
        return serviceDAO.findById(id);
    }

    @Override
    public List<Service> searchName(String name) {
        return null;
    }
}
