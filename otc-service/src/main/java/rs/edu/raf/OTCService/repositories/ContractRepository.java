package rs.edu.raf.OTCService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rs.edu.raf.OTCService.data.entity.Contract;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    @Query("select contract from Contract contract where contract.contractStatus='WAITING'")
    List<Contract> getAllWaitingContracts();

    @Query("select contract from Contract contract where contract.contractStatus='APPROVED'")
    List<Contract> getAllApprovedContracts();

    @Query("select contract from Contract contract where contract.contractStatus='REJECTED'")
    List<Contract> getAllRejectedContracts();
}
