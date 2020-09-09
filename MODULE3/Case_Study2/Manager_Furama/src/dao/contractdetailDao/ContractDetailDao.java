package dao.contractdetailDao;

import model.Contract;
import model.ContractDetail;

import java.util.List;

public interface ContractDetailDao {
    List<ContractDetail> findAllContractDetail();

    void create(ContractDetail contractDetail);

    void update(ContractDetail contractDetail);

    void delete(String id);

    ContractDetail findById(int id);

    List<Contract> searchName(String name);
    boolean checkContractIdExists(int id);
}
