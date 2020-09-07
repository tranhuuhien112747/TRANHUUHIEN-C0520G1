package bo.contractBo;

import dao.contractDao.ContractDAO;
import dao.contractDao.ContractDAOImpl;
import model.Contract;

import java.util.List;

public class ContractBoImpl implements ContractBO {
    ContractDAO contractDAO = new ContractDAOImpl();
    @Override
    public List<Contract> findAllContract() {
        return contractDAO.findAllContract();
    }

    @Override
    public void create(Contract contract) {
        contractDAO.create(contract);

    }

    @Override
    public void update(Contract contract) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Contract findById(int id) {
        return contractDAO.findById(id);
    }

    @Override
    public List<Contract> searchName(String name) {
        return contractDAO.searchName(name);
    }
}
