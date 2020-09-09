package bo.contractBo;

import bo.checkValidate.Regex;
import dao.contractDao.ContractDAO;
import dao.contractDao.ContractDAOImpl;
import model.Contract;

import java.util.ArrayList;
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

    @Override
    public List<String> checkValidateCreateContract(int id, String deposit, String totalMoney) {
        List<String> errMessList = new ArrayList<>();
        boolean checkValidateId = checkValidateContractId(id);
        boolean checkValidateDeposit= Regex.checkRegexDoublePositive(deposit);
        boolean checkValidateTotal= Regex.checkRegexDoublePositive(totalMoney);
        if (!(checkValidateId && checkValidateDeposit &&  checkValidateTotal)){
            if (!checkValidateId) {
                errMessList.add("ID unlike");
            } else {
                errMessList.add("");
            }
            if (!checkValidateDeposit) {
                errMessList.add("Deposit must be positive number");
            } else {
                errMessList.add("");
            }
            if (!checkValidateTotal) {
                errMessList.add("Total must be positive number");
            } else {
                errMessList.add("");
            }
        }
        return errMessList;
    }
    private boolean checkValidateContractId(int id) {
        return !contractDAO.checkContractIdExists(id);
    }
}
