package bo.contractBo;

import model.Contract;

import java.util.List;

public interface ContractBO {
    List<Contract> findAllContract();

    void create(Contract contract );

    void update(Contract contract);

    void delete(String id);

    Contract findById(int id);

    List<Contract> searchName(String name);
}
