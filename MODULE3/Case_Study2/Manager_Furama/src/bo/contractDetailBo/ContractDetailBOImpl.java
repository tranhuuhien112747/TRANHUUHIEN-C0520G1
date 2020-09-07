package bo.contractDetailBo;

import dao.contractdetailDao.ContractDetailDao;
import dao.contractdetailDao.ContractDetailDaoImpl;
import model.Contract;
import model.ContractDetail;

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
}
