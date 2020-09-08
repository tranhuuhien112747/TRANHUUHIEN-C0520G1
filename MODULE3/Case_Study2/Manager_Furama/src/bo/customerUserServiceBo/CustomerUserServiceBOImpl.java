package bo.customerUserServiceBo;

import dao.customerUseServiceDao.CustomerUserServiceDAO;
import dao.customerUseServiceDao.CustomerUserServiceDAOImpl;
import model.CustomerUserService;

import java.util.List;

public class CustomerUserServiceBOImpl implements CustomerUserServiceBO {
    CustomerUserServiceDAO userServiceDAO = new CustomerUserServiceDAOImpl();

    @Override
    public List<CustomerUserService> findAllCustomerUserService() {
        return userServiceDAO.findAllCustomerUserService();
    }

}
