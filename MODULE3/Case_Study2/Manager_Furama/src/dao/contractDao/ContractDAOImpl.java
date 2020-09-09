package dao.contractDao;

import dao.DBConnection;
import model.Contract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractDAOImpl implements ContractDAO {
    private static String INSERT_CONTRACT = "insert into contract values (?,?,?,?,?,?,?,?);";
    private static String SELECT_ALL_CONTRACT = "select*from contract;";
    private static String SEARCH_BY_ID = "select*from contract where contract_id like = ?";
    private static final String CHECK_CONTRACT_ID_EXISTS = "SELECT 1 FROM contract WHERE contract_id = ?;";

    @Override
    public List<Contract> findAllContract() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        List<Contract> contractList = new ArrayList<>();
        Contract contract = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_CONTRACT);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("contract_id");
                    String startDate = resultSet.getString("contract_star_date");
                    String endDate = resultSet.getString("contract_end_date");
                    double deposit = resultSet.getDouble("contract_deposit");
                    double totalMoney = resultSet.getDouble("contract_total_money");
                    int employeeId = resultSet.getInt("employee_id");
                    String customerId = resultSet.getString("customer_id");
                    String serviceId = resultSet.getString("service_id");
                    contract = new Contract(id, startDate, endDate, deposit, totalMoney, employeeId, customerId, serviceId);
                    contractList.add(contract);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return contractList;
    }

    @Override
    public void create(Contract contract) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_CONTRACT);
                statement.setInt(1, contract.getContractId());
                statement.setString(2, contract.getContractStart());
                statement.setString(3, contract.getContractEnd());
                statement.setDouble(4, contract.getContractDeposit());
                statement.setDouble(5, contract.getContractMoneyTotal());
                statement.setInt(6, contract.getEmployeeId());
                statement.setString(7, contract.getCustomerId());
                statement.setString(8, contract.getServiceId());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
    }

    @Override
    public void update(Contract contract) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Contract findById(int id) {
        return null;
    }

    @Override
    public List<Contract> searchName(String value) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        List<Contract> contractList = new ArrayList<>();
        Contract contract = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SEARCH_BY_ID);
                statement.setString(1, "%" + value + "%");
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("contract_id");
                    String startDate = resultSet.getString("contract_start_date");
                    String endDate = resultSet.getString("contract_end_date");
                    double deposit = resultSet.getDouble("contract_deposit");
                    double totalMoney = resultSet.getDouble("contract_total_money");
                    int employeeId = resultSet.getInt("employee_id");
                    String customerId = resultSet.getString("customer_id");
                    String serviceId = resultSet.getString("service_id");
                    contract = new Contract(id, startDate, endDate, deposit, totalMoney, employeeId, customerId, serviceId);
                    contractList.add(contract);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return contractList;
    }

    @Override
    public boolean checkContractIdExists(int id) {
        boolean checkExists = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(CHECK_CONTRACT_ID_EXISTS);
                statement.setInt(1, id);
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
