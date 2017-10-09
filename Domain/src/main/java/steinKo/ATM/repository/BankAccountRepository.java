

package steinKo.ATM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import steinKo.ATM.domain.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

	

}
