package dao.contractDao;

import model.Contract;
import model.Service;

import java.util.List;

public interface ContractDAO {
    List<Contract> findAllContract();

    void create(Contract contract );

    void update(Contract contract);

    void delete(String id);

    Contract findById(int id);

    List<Contract> searchName(String name);
}
