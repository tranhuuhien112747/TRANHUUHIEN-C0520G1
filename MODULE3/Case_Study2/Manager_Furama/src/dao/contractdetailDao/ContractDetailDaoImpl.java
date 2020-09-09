package dao.contractdetailDao;

import dao.DBConnection;
import model.Contract;
import model.ContractDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailDaoImpl implements ContractDetailDao {
    private static String SELECT_ALL_DETAIL = "select*from contract_detail;";
    private static String INSERT_CONTRACT_DETAIL = "insert into contract_detail values (?,?,?,?);";
    private static final String CHECK_CONTRACT_ID_EXISTS = "SELECT 1 FROM contract_detail WHERE contract_detail_id = ?;";
    @Override
    public List<ContractDetail> findAllContractDetail() {
        Connection connection = DBConnection.getConnection();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        List<ContractDetail> contractDetailList = new ArrayList<>();
        ContractDetail contractDetail = null;
        if ((connection != null)) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_DETAIL);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int detailID = resultSet.getInt("contract_detail_id");
                    int contractID = resultSet.getInt("contract_id");
                    int attachService = resultSet.getInt("attach_service_id");
                    int quantity = resultSet.getInt("quantity");
                    contractDetail = new ContractDetail(detailID, contractID, attachService, quantity);
                    contractDetailList.add(contractDetail);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }

        }
        return contractDetailList;
    }

    @Override
    public void create(ContractDetail contractDetail) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_CONTRACT_DETAIL);
                statement.setInt(1,contractDetail.getContractDetailId());
                statement.setInt(2, contractDetail.getContractId());
                statement.setInt(3, contractDetail.getAttachServiceId());
                statement.setInt(4, contractDetail.getQuantity());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
    }

    @Override
    public void update(ContractDetail contractDetail) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public ContractDetail findById(int id) {
        return null;
    }

    @Override
    public List<Contract> searchName(String name) {
        return null;
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
