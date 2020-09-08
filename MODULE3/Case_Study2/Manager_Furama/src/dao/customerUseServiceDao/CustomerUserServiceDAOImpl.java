package dao.customerUseServiceDao;

import dao.DBConnection;
import model.CustomerUserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerUserServiceDAOImpl implements CustomerUserServiceDAO{
    private static String CUSTOMER_USER_SERVICE="SELECT customer.customer_name, customer.customer_id, service.service_id," +
            " service.service_name, contract.contract_id, attach_service.attach_service_name\n" +
            "FROM customer\n" +
            "INNER JOIN contract ON customer.customer_id = contract.customer_id\n" +
            "INNER JOIN service ON service.service_id = contract.service_id\n" +
            "INNER JOIN contract_detail ON contract.contract_id = contract_detail.contract_id\n" +
            "INNER JOIN attach_service ON contract_detail.attach_service_id = attach_service.attach_service_id";
    @Override
    public List<CustomerUserService> findAllCustomerUserService() {
        List<CustomerUserService> customerUserServiceList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        CustomerUserService userService;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(CUSTOMER_USER_SERVICE);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String customerId = resultSet.getString("customer.customer_id");
                    String customerName = resultSet.getString("customer.customer_name");
                    String serviceId = resultSet.getString("service.service_id");
                    String serviceName = resultSet.getString("service.service_name");
                    int contractId = resultSet.getInt("contract.contract_id");
                    String attachServiceName = resultSet.getString("attach_service.attach_service_name");
                    userService=new CustomerUserService(customerId,customerName,contractId,serviceId,serviceName,attachServiceName);
                    customerUserServiceList.add(userService);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customerUserServiceList;
    }

}
