package steinKo.ATM.test.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.factory.annotation.Autowired;

import steinKo.ATM.Category.IntegrationTest;
import steinKo.ATM.domain.BankAccount;
import steinKo.ATM.repository.BankAccountRepository;

@Category(IntegrationTest.class)
public class BankAccountTest  extends AbstractTest{
	
	
	 @Autowired
	    private BankAccountRepository repository;
	 @Test
		public void shouldFindNoBankAccounIfRepositoryIsEmpty() {
			Iterable<BankAccount> accounts = repository.findAll();
					assertThat(accounts).isEmpty();
					
		}
	 
	@Test
	public void shuoldFindOneBankAccount() {
		     BankAccount account = new  BankAccount(100);
		     repository.save(account);
		    long noOfAccounts =  repository.count();
		    assertEquals(1l,noOfAccounts);
		  }
	
	@Test
	public void shouldDeleteAllBankAccounts() {
		repository.save(new BankAccount(100));
		repository.save(new BankAccount(200));

		repository.deleteAll();

		assertThat(repository.findAll()).isEmpty();
	}
	
	@Test
	public void shouldFindBankAccountById() {
		BankAccount account1 = new BankAccount(100);
		repository.save(account1);

		BankAccount account2 = new BankAccount(200);
		repository.save(account2);

		BankAccount foundAccount = repository.findOne(account2.getId());
		assertThat(foundAccount).isEqualTo(account2);
	}
	@Test
	public void shouldFindAllCustomers() {
		BankAccount account1 = new BankAccount(100);
		repository.save(account1);

		BankAccount account2 = new BankAccount(200);
		repository.save(account2);

		BankAccount account3 = new BankAccount(300);
		repository.save(account3);


		Iterable<BankAccount> bankaccounts = repository.findAll();
		assertThat(bankaccounts).hasSize(3).contains(account1, account2, account3);
	}
	
	@Test
	public void shouldFindSaldo() {
		BankAccount account1 = new BankAccount(100);
		repository.save(account1);
		BankAccount foundAccount = repository.findOne(account1.getId());
        assertEquals(foundAccount.saldo(),100);
	}
	
	@Test
	public void shouldFindNewSaldo() {
		BankAccount account1 = new BankAccount(100);
		repository.save(account1);
		account1.gi(100);
		repository.save(account1);
		BankAccount foundAccount = repository.findOne(account1.getId());
        assertEquals(foundAccount.saldo(),200);
	}
	
	@Test
	public void shouldFindOldSaldo() {
		BankAccount account1 = new BankAccount(100);
		repository.save(account1);
		account1.gi(100);
		BankAccount foundAccount = repository.findOne(account1.getId());
        //assertEquals(foundAccount.saldo(),100);
	}
	
}	

