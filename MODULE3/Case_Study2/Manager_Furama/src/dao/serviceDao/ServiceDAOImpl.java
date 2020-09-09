package dao.serviceDao;

import dao.DBConnection;
import model.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAOImpl implements ServiceDAO {
    private static String SELECT_ALL_SERVICE = "select*from service";
    private static String SELECT_SERVICE_BY_ID = "select*from service where service_id = ? ";
    private static String INSERT_SERVICE = "insert into service values (?,?,?,?,?,?,?,?,?,?,?);";
    private static String DELETE_SERVICE_BY_ID = "delete from service where service_id = ?";
    private static String SEARCH_ID_SERVICE = "select*from service where service_id like ?";
    private static final String CHECK_SERVICE_ID_EXISTS = "SELECT 1 FROM service WHERE service_id = ?;";
    @Override
    public List<Service> findAllService() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Service> serviceList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_SERVICE);
                resultSet = statement.executeQuery();
                Service service = null;
                while (resultSet.next()) {
                    String id = resultSet.getString("service_id");
                    String name = resultSet.getString("service_name");
                    double area = resultSet.getDouble("service_area");
                    double cost = resultSet.getDouble("service_cost");
                    int maxPeople = resultSet.getInt("service_max_people");
                    int rentTypeId = resultSet.getInt("rent_type_id");
                    int serviceTypeId = resultSet.getInt("service_type_id");
                    String standardRoom = resultSet.getString("standard_room");
                    String description = resultSet.getString("description_other");
                    double poolArea = resultSet.getDouble("pool_area");
                    int numberFloor = resultSet.getInt("number_floor");
                    service=new Service(id,name,area,cost,maxPeople,rentTypeId,serviceTypeId,standardRoom,description,poolArea,numberFloor);
                    serviceList.add(service);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return serviceList;
    }

    @Override
    public void create(Service service) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_SERVICE);
                statement.setString(1, service.getServiceId());
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
    public void delete(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_SERVICE_BY_ID);
                statement.setString(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
    }

    @Override
    public Service findById(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Service service = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_SERVICE_BY_ID);
                statement.setString(1,id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("service_name");
                    double area = resultSet.getDouble("service_area");
                    double cost = resultSet.getDouble("service_cost");
                    int maxPeople = resultSet.getInt("service_max_people");
                    int rentTypeId = resultSet.getInt("rent_type_id");
                    int serviceTypeId = resultSet.getInt("service_type_id");
                    String standardRoom = resultSet.getString("standard_room");
                    String description = resultSet.getString("description_other");
                    double poolArea = resultSet.getDouble("pool_area");
                    int numberFloor = resultSet.getInt("number_floor");
                    service=new Service(id,name,area,cost,maxPeople,rentTypeId,serviceTypeId,standardRoom,description,poolArea,numberFloor);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return service;
    }

    @Override
    public List<Service> searchName(String value) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Service> serviceList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SEARCH_ID_SERVICE);
                statement.setString(1, "%" + value + "%");
                resultSet = statement.executeQuery();
                Service service = null;
                while (resultSet.next()) {
                    String id = resultSet.getString("service_id");
                    String name = resultSet.getString("service_name");
                    double area = resultSet.getDouble("service_area");
                    double cost = resultSet.getDouble("service_cost");
                    int maxPeople = resultSet.getInt("service_max_people");
                    int rentTypeId = resultSet.getInt("rent_type_id");
                    int serviceTypeId = resultSet.getInt("service_type_id");
                    String standardRoom = resultSet.getString("standard_room");
                    String description = resultSet.getString("description_other");
                    double poolArea = resultSet.getDouble("pool_area");
                    int numberFloor = resultSet.getInt("number_floor");
                    service=new Service(id,name,area,cost,maxPeople,rentTypeId,serviceTypeId,standardRoom,description,poolArea,numberFloor);
                    serviceList.add(service);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return serviceList;
    }

    @Override
    public boolean checkServiceIdExists(String id) {
        boolean checkExists = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(CHECK_SERVICE_ID_EXISTS);
                statement.setString(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    checkExists = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return checkExists;
    }
}
