package bo.contractDetailBo;

import bo.checkValidate.Regex;
import dao.contractdetailDao.ContractDetailDao;
import dao.contractdetailDao.ContractDetailDaoImpl;
import model.Contract;
import model.ContractDetail;

import java.util.ArrayList;
import java.util.List;

public class ContractDetailBOImpl implements ContractDetailBO {
    ContractDetailDao contractDetailDao = new ContractDetailDaoImpl();

    @Override
    public List<ContractDetail> findAllContractDetail() {
        return contractDetailDao.findAllContractDetail();
    }

    @Override
    public void create(ContractDetail contractDetail) {
        contractDetailDao.create(contractDetail);
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
    public List<String> checkValidateCreateContract(int id, String quantity) {
        List<String> errMessList = new ArrayList<>();
        boolean checkValidateId = checkValidateContractId(id);
        boolean checkValidateQuantity = Regex.checkRegexIntegerPositive(quantity);

        if (!(checkValidateId && checkValidateQuantity)) {
            if (!checkValidateId) {
                errMessList.add("ID unlike");
            } else {
                errMessList.add("");
            }
            if (!checkValidateQuantity) {
                errMessList.add("Deposit must be positive number");
            } else {
                errMessList.add("");
            }
        }
        return errMessList;
    }

    private boolean checkValidateContractId(int id) {
        return !contractDetailDao.checkContractIdExists(id);
    }
}
