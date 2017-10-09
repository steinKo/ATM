package steinKo.ATM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import steinKo.ATM.domain.Bank;
public interface BankRepository extends JpaRepository<Bank, Long> {

}
