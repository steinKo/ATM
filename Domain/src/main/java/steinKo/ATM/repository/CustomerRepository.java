package steinKo.ATM.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import steinKo.ATM.domain.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Long>{

}
