package dao.serviceDao;

import dao.DBConnection;
import model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ServiceDAOImpl implements ServiceDAO{
    private static String SELECT_ALL_SERVICE="";
    private static String INSERT_SERVICE="insert into service values (?,?,?,?,?,?,?,?,?,?,?);";
    @Override
    public List<Service> findAllService() {
        return null;
    }

    @Override
    public void create(Service service) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_SERVICE);
                statement.setInt(1, service.getServiceId());
                statement.setString(2, service.getServiceName());
                statement.setDouble(3, service.getArea());
                statement.setDouble(4, service.getServiceCost());
                statement.setInt(5, service.getMaxPeople());
                statement.setInt(6, service.getRentTypeId());
                statement.setInt(7, service.getServiceTypeId());
                statement.setString(8, service.getStandardRoom());
                statement.setString(9, service.getDescription());
                statement.setDouble(10, service.getAreaPool());
                statement.setInt(11, service.getNumberFloor());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }

    }

    @Override
    public void update(Service service) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Service findById(int id) {
        return null;
    }

    @Override
    public List<Service> searchName(String name) {
        return null;
    }
}
