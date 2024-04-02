package rs.edu.raf.BankService.repository.credit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.edu.raf.BankService.data.entities.CreditRequest;

@Repository
public interface CreditRequestRepository extends JpaRepository<CreditRequest, Long> {

}
